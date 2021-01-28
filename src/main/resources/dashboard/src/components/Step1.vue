<template>
<div>
    <el-row>
        <!-- 添加节点 -->
        <el-col :span="6">
            <h3>添加redis节点</h3>
            <el-form ref="node" :model="this.node" label-width="70px">
                <el-form-item label="nodeName" prop="nodeName">
                    <el-input v-model="node.nodeName" />
                </el-form-item>
                <el-form-item label="host" prop="host">
                    <el-input v-model="node.host" />
                </el-form-item>
                <el-form-item label="port" prop="port">
                    <el-input v-model="node.port" />
                </el-form-item>
                <el-form-item label="password" prop="password">
                    <el-input v-model="node.password" />
                </el-form-item>
                <el-form-item>
                    <el-button plain @click="checkNode">检查</el-button>
                    <el-button plain @click="addNode">添加</el-button>
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
                nodeIndex:"1",
                nodeName:"",
                host:"",
                port:"",
                password:"",
            }
        }
    },
    methods: {
        checkNode() {
            console.log(this.$store.state.addr);
            this.$http.post(this.$store.state.url.check,this.node,{emulateJSON:false})
                .then((response) => {
                    console.log(response);
                },(err) => {
                    console.log(err);
                });
        },
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