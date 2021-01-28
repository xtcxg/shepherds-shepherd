import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    addr:"http://127.0.0.1:3601",
    url: {
      check: ""
    }
  },
  mutations: {
    init(state,val) {
      state.url = {
        check: val + "/check"
      }
    }
  },
  actions: {
  },
  modules: {
  }
})
