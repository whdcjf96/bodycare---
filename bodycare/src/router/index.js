import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    alias: '/home',
    name: 'home',
    component: () => import('../views/HomeView.vue')
  },
  // TODO : baisc 라우터 달기
  {
    path: '/basic',
    name: 'baisc',
    component: () => import('../components/weightmanage/Basic.vue')
  },
  // TODO : weight 라우터 달기
  {
    path: '/weight',
    name: 'weight',
    component: () => import('../components/weightmanage/Weight.vue')
  },
  // TODO : food 라우터 달기
  {
    path: '/food',
    name: 'food',
    component: () => import('../components/weightmanage/Food.vue')
  },
  {
    path: '/food/:id',
    name: 'food-id',
    component: () => import('../components/weightmanage/Food.vue')
  },
  // TODO : FoodInput 라우터 달기
  {
    path: '/foodInput',
    name: 'foodInput',
    component: () => import("../components/weightmanage/FoodInput")

  },

  // TODO : ActivityManage 라우터 달기
  {
    path: '/activityManage',
    name: 'activityManage',
    component: () => import("../components/weightmanage/ActivityManage")

  },
  // TODO : ActivityInput 라우터 달기
  {
    path: '/activityInput',
    name: 'activityInput',
    component: () => import("../components/weightmanage/ActivityInput")

  },

  // TODO : DietCom 라우터 달기
  {
    path: '/diet',
    name: 'diet',
    component: () => import("../components/exerciseAssistant/Diet")

  },
  // TODO : supplement 라우터 달기
  {
    path: '/supplement',
    name: 'supplement',
    component: () => import("../components/exerciseAssistant/Supplement")

  },
  {
    path: '/login',
    name: 'login',
    component: () => import("../components/userManage/LogIn")

  },
  {
    path: '/register',
    name: 'register',
    component: () => import("../components/userManage/Register")

  },
  {
    path: '/mypage',
    name: 'mypage',
    component: () => import("../components/userManage/MyPage")

  },
  {
    path:'/updatemypage',
    name:'updatemypage',
    component: () => import("../components/userManage/UpdateMyPage")
  }

]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

// 로그인 권한이 없는 사람과 있는 사람을 구별해서 화면을 보여주는 부분을 추가
// 메뉴간 서로 이동할때 중간에 가로채는 이벤트
// 1st 매개변수 : to(이동할 페이지)
// 2nd 매개변수 : from(전 페이지)
// 3rd 매개변수 : next(다음화면으로 이동하는 함수)
router.beforeEach((to,from,next) => {
  // 권한관리 : 회원, 비회원
  // 인증 없이 접근가능한 경로(화면)
  const publicPages = ["/login","/register","/"];
  // 인증이 있어야만 접근 가능한 경로(화면)
  const authRequired = !publicPages.includes(to.path);
  // 웹 토큰을 가져와서 확인
  // 웹 토큰이 있으면 : 회원
  // 웹 토큰이 없으면 : 비회원
  
  const loggedIn = localStorage.getItem("user");
  
  // 비회원일 경우
  if(authRequired && !loggedIn) {
      // 강제로 /login 화면으로 전환
      next("/login");
  }
  else
  {
      // 다음 화면으로 이동 
      next();
  }
  })
export default router
