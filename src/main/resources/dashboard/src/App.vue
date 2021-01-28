<template>
  <div id="app">
    <div v-if="this.step===1">
      <Step1/>
    </div>
  </div>
</template>



<script>
import Step1 from "./components/Step1"
export default {
  name: 'app',
  components: {
    Step1
  },
  data() {
    return {
      step: 1,
    };
  },
  mounted () {
    this.$store.commit("init","http://127.0.0.1:3601");
  },
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
