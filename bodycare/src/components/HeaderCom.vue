<template>
  <div id="wrapper" style="width: 100%">
    <div style="width: 100%">
      <!-- Topbar -->
      <nav
          class="
          navbar navbar-expand navbar-light
          bg-gradient-primary
          topbar
          static-top
          shadow
        "
      >
        <!-- Topbar Navbar -->

        <ul class="font-weight-bold navbar-nav ">
          <li class="nav-item">
            <router-link
                to="/"
                class=" nav-link mr-5 text-white "
                id="navbarDropdownMenuLink"
                aria-haspopup="true"
                aria-expanded="false"
            >
              <div class="sidebar-brand-icon ">
                <i class="fas fa-laptop-medical"></i>
              </div>
              <div class="sidebar-brand-text mx-3">Nutrition <br> Assistant</div>
            </router-link>
          </li>
          <li class="nav-item">
            <router-link
                to="/basic"
                class="nav-link mr-5 text-white"
                id="navbarDropdownMenuLink"
                aria-haspopup="true"
                aria-expanded="false"
            >
              체중관리
            </router-link>
          </li>

          <li class="nav-item">
            <router-link
                to="/diet"
                class="nav-link mr-5 text-white"
                id="navbarDropdownMenuLink"
                aria-haspopup="true"
                aria-expanded="false"
            >
              운동도우미
            </router-link>
          </li>
          <div v-if="loggedIn==true">
            <li class="nav-item" style="position: fixed; right: 50px">
              <a href @click.prevent="logOut" class="nav-link text-white">
                <!--            웹 아이콘 추가 : LogOut -->
                로그아웃
              </a>
            </li>
            <li class="nav-item" style="position: fixed; right: 100px;">
              <router-link
                  to="/mypage"
                  class="nav-link mr-5 text-white"
                  id="navbarDropdownMenuLink"
                  aria-haspopup="true"
                  aria-expanded="false"
              >
                마이페이지
              </router-link>
            </li>
          </div>
          <div v-else>
            <li class="nav-item" style="position: fixed; right: 50px">
              <a href="/login" class="nav-link text-white">
                <!--            웹 아이콘 추가 : LogOut -->
                로그인
              </a>
            </li>
          </div>
        </ul>
      </nav>
      <!-- End of Topbar -->

      <!-- 화면 전체 시작 -->
      <div class="container-fluid">
        <!-- 화면 바디 시작 -->
        <div class="row">
          <!--  메인 바디-->
        </div>
        <!-- 화면 바디 끝 -->
      </div>
      <!-- 화면 전체 끝 -->
    </div>
  </div>


</template>

<script>
export default {
  methods:{
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
  },
  computed: {
    // 값 : false, true
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
};
</script>

<style>
</style>