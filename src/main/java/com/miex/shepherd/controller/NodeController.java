package com.miex.shepherd.controller;

import com.miex.shepherd.domain.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

@Slf4j
@CrossOrigin
@RestController
public class NodeController {

    @PostMapping("check")
    public Boolean check(@RequestBody Node node ,@RequestHeader("workerId") String workerId) {
        System.out.println(workerId);
        try {
            log.info("检查节点信息:" + node.toString());
            Jedis jedis = new Jedis("10.168.254.100", 6379);
            jedis.auth("8Y8Fmx7mo");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @PostMapping
    public Boolean add(){
        return true;
    }
}
