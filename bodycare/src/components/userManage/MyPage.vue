<template>
  <div id="wrapper" style="width: 100%">
    <div>
      <!-- Sidebar -->
      <ul
          class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
          id="accordionSidebar"
      >
        <!-- Sidebar - Brand -->
        <router-link
            to="/"
            class="sidebar-brand d-flex align-items-center justify-content-center"
        >
          <div class="sidebar-brand-icon ">
            <i class="fas fa-laptop-medical"></i>
          </div>
          <div class="sidebar-brand-text mx-3">Nutrition Assistant</div>
        </router-link>

        <!-- TODO : DietCom 라우터버튼 -->
        <!-- Nav Item - ActivityManage -->
        <li class="nav-item">
          <router-link to="/mypage" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>기본</span>
          </router-link>
        </li>
      </ul>
      <!-- End of Sidebar -->
    </div>
    <div style="width: 100%">
      <!-- Topbar -->
      <nav
          class="
          navbar navbar-expand navbar-light
          bg-gradient-primary2
          topbar
          static-top
          shadow
        "
      >
        <!-- Topbar Navbar -->
        <ul class="font-weight-bold navbar-nav ">
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
        </ul>
      </nav>
      <!-- End of Topbar -->

      <!-- 화면 전체 시작 -->
      <div class="container-fluid">

        <div class="row mt-3">
          <div class="col">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <div class="row">
                  <h3 class="m-0 font-weight-bold  text-primary col">
                    마이페이지
                    <router-link to="/updatemypage">
                      <button class="btn btn-primary float-right">정보 수정하기</button>
                    </router-link>
                  </h3>
                  <!-- 추가하기버튼 끝 -->
                </div>
              </div>
              <div class="card-body">
                <!--                마이페이지 시작-->
                <div class="row">
                  <!--    이름 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          이름
                        </h6>
                      </div>
                      <div class="card-body">
                         {{cu.name}}
                      </div>
                    </div>
                  </div>
                  <!--                  이름 끝-->


                </div>
                <!--    이메일 시작-->
                <div class="row">
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          이메일
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.email }}
                      </div>
                    </div>
                  </div>
                  <!--                  이메일 끝-->
                </div>

                <div class="row">
                  <!--    키 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          키
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.height }}
                      </div>
                    </div>
                  </div>
                  <!--                  키 끝-->
                  <!--    성별 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          성별
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.gender }}
                      </div>
                    </div>
                  </div>
                  <!--                  성별 끝-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          나이
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.age }}
                      </div>
                    </div>
                  </div>
                  <!--                  성별 끝-->
                </div>
<!--                ////////////////////////////////-->
                <div class="row">
                  <!--    키 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          체중
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.weight }}
                      </div>
                    </div>
                  </div>
                  <!--                  키 끝-->
                  <!--    성별 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          체지방
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.bodyFat }}
                      </div>
                    </div>
                  </div>
                  <!--                  성별 끝-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          골격근량
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.muscleMass }}
                      </div>
                    </div>
                  </div>
                  <!--                  성별 끝-->
                </div>
<!--                ////////////////////////////////-->
                <div class="row">
                  <!--    키 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          목표 체지방
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.fatGoal }}
                      </div>
                    </div>
                  </div>
                  <!--                  키 끝-->
                  <!--    성별 시작-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          시작시 줄일 칼로리
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.kcalStart }}
                      </div>
                    </div>
                  </div>
                  <!--                  성별 끝-->
                  <div class="col">
                    <div class="card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">
                          매주 줄일 칼로리
                        </h6>
                      </div>
                      <div class="card-body">
                        {{ cu.kcalWeekly }}
                      </div>
                    </div>
                  </div>
                  <!--                  성별 끝-->
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
import UserDataService from "@/services/UserDataService";
export default {
  name: "MyPage",
  data(){
    return{
      // currentUser: null,
      message:"",
      cu:{}
    }
  },
  computed:{
    currentUser(){
      return this.$store.state.auth.user;
    }
  },
  mounted() {
    this.message="";
    console.log("mounted"+this.currentUser.id);
    this.getUsersById(this.currentUser.id);
  },
  methods:{
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
    getUsersById(id){
      UserDataService.getUsersById(id)
          .then((response)=>{
            this.cu= response.data;
            console.log(response.data + "~~~~~~~~~~~~~~~");
          }).catch((e)=>{
            console.log(e+"~~~~~~~~~~~~~~~`");
      })
    }
  }
}
</script>

<style scoped>

</style>