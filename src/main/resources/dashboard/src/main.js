import Vue from 'vue'
import App from './App.vue'
import store from './store'
import './plugins/element.js'
import VueResource from 'vue-resource'

Vue.config.productionTip = false
Vue.use(VueResource)
Vue.http.headers.common['workerId'] = "8abc77ab";

new Vue({
  store,
  render: h => h(App)
}).$mount('#app')
