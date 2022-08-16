import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'

// 뷰의 유효성 체크 import
import VeeValidate from "vee-validate";

import BootstrapVue from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
// 뷰의 유효성 체크 import


Vue.use(BootstrapVue)

// 뷰 유효성 체크 모듈 사용 설정
Vue.use(VeeValidate);

Vue.config.productionTip = false

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
