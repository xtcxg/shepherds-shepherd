<template>
<div>
    <el-row>
        <!-- 添加节点 -->
        <el-col :span="8">
            <h3>添加redis节点</h3>
            <el-form ref="node" :model="node" label-width="65px">
                <el-form-item label="name" prop="name">
                    <el-input v-model="this.node.name" />
                </el-form-item>
                <el-form-item label="host" prop="host">
                    <el-input v-model="this.node.host" />
                </el-form-item>
                <el-form-item label="port" prop="port">
                    <el-input v-model="this.node.port" />
                </el-form-item>
                <el-form-item label="password" prop="password">
                    <el-input v-model="this.node.password" />
                </el-form-item>
                <el-form-item>
                    <el-button plain @click="addNode">检查</el-button>
                    <el-button plain>添加</el-button>
                </el-form-item>
            </el-form>
        </el-col>

        <!--  -->
        <el-col :span="14">

        </el-col>

    </el-row>
</div>
</template>

<script>
export default {
    name: "step1",
    data() {
        return {
            prop: {
                "server.port":"",
                groups: [],
                nodes:[],
            },
            group: {
                groupName: "",
                groupIndex: "",
                nodes:[]
            },
            node: {
                nodeIndex:"",
                nodeName:"",
                host:"",
                port:"",
                password:"",
            }
        }
    },
    methods: {
        addNode() {
            let node = this.node;
            this.prop.nodes.push(node);
        },
        resetNode(n) {
            console.log(this.prop);
        }
    }
}
</script>