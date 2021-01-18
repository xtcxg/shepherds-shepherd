package com.miex.shepherd;

import com.alibaba.fastjson.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class ShepherdApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ShepherdApplication.class);
        app.setDefaultProperties(init(args[0]));
        app.run(args);
    }

    private static Map<String,Object> init(String id){
        Map<String,Object> properties = new HashMap<>();
        properties.put("spring.datasource.url","jdbc:sqlite:D:\\workspace\\shepherds\\src\\main\\resources\\sqlite\\shepherds.db");
        properties.put("spring.datasource.driver-class-name","org.sqlite.JDBC");
        DataSourceProperties dataSourceProperties = new DataSourceProperties();
        dataSourceProperties.setUrl((String) properties.get("spring.datasource.driver-class-name"));
        // 将数据库中的配置取出，worker 表 id=0
        try {
            Class.forName((String) properties.get("spring.datasource.driver-class-name"));
            Connection conn = DriverManager.getConnection((String) properties.get("spring.datasource.url"));
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM worker WHERE worker_id = '" + id + "'");
            resultSet.next();
            JSONObject.parseObject(resultSet.getString("prop")).forEach(properties::put);
            resultSet.close();
            statement.close();
            conn.close();
        } catch ( Exception e ) {
            e.printStackTrace();
            System.exit(0);
        }
        return properties;
    }

}
