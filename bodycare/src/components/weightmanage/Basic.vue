<template>
  <div id="wrapper" style="width: 100%">
    <div>
      <!-- Sidebar -->
      <ul
          class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
          id="accordionSidebar"
          style="height: 100%"
      >
        <!-- Sidebar - Brand -->
        <router-link
            to="/"
            class="sidebar-brand d-flex align-items-center justify-content-center"
        >
          <div class="sidebar-brand-icon">
            <i class="fas fa-laptop-medical"></i>
          </div>
          <div class="sidebar-brand-text mx-3">Nutrition Assistant</div>
        </router-link>

        <!-- TODO : Basic 라우터버튼 -->
        <!-- Nav Item - Basic -->
        <li class="nav-item">
          <router-link to="/basic" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>기본</span>
          </router-link>
        </li>

        <!-- TODO : ActivityManage 라우터버튼 -->
        <!-- Nav Item - ActivityManage -->
        <li class="nav-item">
          <router-link to="/activityManage" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>활동관리</span>
          </router-link>
        </li>

        <!-- TODO : Food 라우터버튼 -->
        <!-- Nav Item - Food -->
        <li class="nav-item">
          <router-link to="/food" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>식단관리</span>
          </router-link>
        </li>

        <!-- TODO : weightHisotry 라우터버튼 -->
        <!-- Nav Item - weightHisotry -->
        <li class="nav-item">
          <router-link to="/weight" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>체중추적</span>
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
<!--          </div>-->
          <li class="nav-item" style="position: fixed; right: 100px">
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
        <!-- 화면 바디 시작 -->
        <!-- 현재 날짜 출력 시작 -->
        <!-- TODO : 현재 날짜 출력 -->
        <div class="row">
          <div
              class="ma-0 pa-3 col col-12"
              style="
              color: #4e73df;
              font-size: 30px;
              font-weight: bold;
              text-align: center;
            "
          >
            <span>&lt; </span>{{ today }}<span> &gt;</span>
          </div>
        </div>
        <!-- 현재 날짜 출력 끝 -->

        <!-- 화면 시작 -->
        <div class="basic">
          <!-- 본문 시작 -->
          <div class="row no-gutters align-center justify-center">
            <!-- 체성분 인풋란 -->
            <div class="mt-3 col-sm-4 col-4">
              <!-- 체중 입력창 시작 -->

              <div
                  class="
                  big
                  pa-4
                  ma-3
                  rounded-lg
                  v-card v-card--flat
                  v-sheet
                  theme--light
                "
              >

                <div class="card shadow mb-4">
                  <div class="card-header py-1">
                    <div
                        class="m-0 font-weight-bold text-primary"
                    >
                      체중
                    </div>
                  </div>
                  <div  class=" card-body text-center font-weight-bold display-5">
                    {{cu.weight}}
                    <h6 class="float-right">kg</h6>
                  </div>
                </div>

              </div>
            </div>
            <!-- 체중 입력창 끝 -->

            <!-- 체지방률 입력창 시작 -->
            <div class="mt-3 col-sm-4 col-4">
              <div
                  class="
                  big
                  pa-4
                  ma-3
                  rounded-lg
                  v-card v-card--flat
                  v-sheet
                  theme--light
                "
              >
                <div class="card shadow mb-4">
                  <div class="card-header py-1">
                    <div
                        class="m-0 font-weight-bold text-primary"
                    >
                      체지방률
                    </div>
                  </div>
                  <div  class=" card-body text-center font-weight-bold display-5">
                    {{cu.bodyFat}}
                    <h6 class="float-right">%</h6>
                  </div>
                </div>
              </div>
            </div>
            <!-- 체지방률 입력창 끝 -->

            <!-- 골격근량 입력창 시작 -->
            <div class="mt-3 col-sm-4 col-4">
              <div
                  class="
                  big
                  pa-4
                  ma-3
                  rounded-lg
                  v-card v-card--flat
                  v-sheet
                  theme--light
                "
              >
                <div class="card shadow mb-4">
                  <div class="card-header py-1">
                    <div
                        class="m-0 font-weight-bold text-primary"
                    >
                      골격근량
                    </div>
                  </div>
                  <div  class=" card-body text-center font-weight-bold display-5">
                    {{cu.muscleMass}}
                    <h6 class="float-right">Kg</h6>
                  </div>
                </div>
              </div>
            </div>
            <!-- 골격근량 입력창 끝-->

            <!-- 가로그래프 시작 -->
            <!-- <div class="graph-wrapper">
              <div class="percent-indicator">
                <div class="per-3"></div>
                <div class="per-8"></div>
                <div class="per-12"></div>
                <div class="per-18"></div>
                <div class="per-25"></div>
                <div class="per-30"></div>
              </div>
              <ul class="graph">
                <br/>
                <br/>
                <li class="item1" :style="{ width: muscleg }"></li>
                <br/>
                <br/>
                <br/>
                <li class="item2" :style="{ width: bodyFatg }"></li>
              </ul>
            </div> -->
            <!-- 가로그래프 끝 -->

            <!-- 가로그래프 시작 -->
            <div class="ml-5 row">
              <div class="col-6">
                <vue-speedometer
                    :width="500"
                    :needleHeightRatio="0.7"
                    :value="bodyFatg"
                    :segmentColors='[  "#1245AB","#3669CF","#5A8DF3","#7EB1FF","#A2D5FF",]'
                    currentValueText="체지방률"
                    :customSegmentLabels='[
        {
          text: "매우 낮음",
          position: "INSIDE",
          color: "#fff",
        },
        {
          text: "낮음",
          position: "INSIDE",
          color: "#fff",
        },
        {
          text: "보통",
          position: "INSIDE",
          color: "#fff",
          fontSize: "19px",
        },
        {
          text: "높음",
          position: "INSIDE",
          color: "#fff",
        },
        {
          text: "매우 높음",
          position: "INSIDE",
          color: "#fff",
        },
      ]'
                    :ringWidth="47"
                    :needleTransitionDuration="5555"
                    needleTransition="easeElastic"
                    needleColor="#003399"
                    textColor="#003399"
                />
              </div>
              <div class="col-6">
                <vue-speedometer
                    :width="500"
                    :needleHeightRatio="0.7"
                    :value="muscleg"
                    :segmentColors='["#A2D5FF", "#7EB1FF", "#5A8DF3","#3669CF","#1245AB"]'
                    currentValueText="골격근량"
                    :customSegmentLabels='[
        {
          text: "매우 낮음",
          position: "INSIDE",
          color: "#fff",
        },
        {
          text: "낮음",
          position: "INSIDE",
          color: "#fff",
        },
        {
          text: "보통",
          position: "INSIDE",
          color: "#fff",
          fontSize: "19px",
        },
        {
          text: "높음",
          position: "INSIDE",
          color: "#fff",
        },
        {
          text: "매우 높음",
          position: "INSIDE",
          color: "#fff",
        },
      ]'
                    :ringWidth="47"
                    :needleTransitionDuration="5555"
                    needleTransition="easeElastic"
                    needleColor="#003399"
                    textColor="#003399"
                />

              </div>
            </div>
            <!-- 가로그래프 끝 -->

            <!-- 추천 체중관리 시작 -->
            <div class="row">
              <div class="col">
                <div class="card shadow mb-4">
                  <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">추천 체중 관리</h6>
                  </div>
                  <div class="ml-3 mt-2 v-card__text font-weight-bold">
                    다음 버튼을 누르시면, 체중당 단백질, 칼로리 조정 값을 입력하실
                    수 있습니다.
                  </div>
                  <div id="app" class="ml-3 mt-2 mb-3 v-card__text font-weight-bold">
                    <h1 v-if="cu.muscleMass<1 || cu.bodyFat<1">
                      정보를 입력해 주세요
                    </h1>
                    <h1 v-else-if="cu.muscleMass<=35 && cu.bodyFat<=17">
                      <router-link to="/activityManage">
                        <button class="btn btn-primary ">벌크업</button>
                      </router-link>
                    </h1>
                    <h1 v-else-if="cu.muscleMass<=35 && cu.bodyFat>18">
                      <router-link to="/activityManage">
                        <button class="btn btn-primary ">다이어트</button>
                      </router-link>
                      <router-link to="/activityManage">
                        <button class="ml-3 btn btn-primary ">린매스업</button>
                      </router-link>
                    </h1>
                    <h1 v-else-if="cu.muscleMass>42 && cu.bodyFat<=17">
                      <router-link to="/activityManage">
                        <button class="btn btn-primary ">커팅</button>
                      </router-link>
                    </h1>
                    <h1 v-else-if="36<cu.muscleMass<=42 && cu.bodyFat<=17">
                      <router-link to="/activityManage">
                        <button class="btn btn-primary ">벌크업</button>
                      </router-link>
                      <router-link to="/activityManage">
                        <button class="ml-3 btn btn-primary ">컷팅</button>
                      </router-link>
                    </h1>
                    <h1 v-else-if="36<cu.muscleMass<=42 && cu.bodyFat>=18">
                      <router-link to="/activityManage">
                        <button class="btn btn-primary ">다이어트</button>
                      </router-link>
                      <router-link to="/activityManage">
                        <button class="ml-3 btn btn-primary ">린매스업</button>
                      </router-link>
                    </h1>

                    <h1 v-else-if="cu.muscleMass>42 && cu.bodyFat>18">
                      <router-link to="/activityManage">
                        <button class="ml-3 btn btn-primary ">다이어트</button>
                      </router-link>
                    </h1>
                    <h1 v-else> 정보를 입력해주세요.</h1>
                  </div>
                </div>
              </div>
            </div>
            <!-- 추천 체중관리 끝 -->
          </div>
          <!-- 본문 끝 -->
        </div>
        <!-- 화면 끝 -->
      </div>
      <!-- 화면 전체 끝 -->
    </div>
  </div>
</template>

<script>
/*eslint-disable*/

import dayjs from "dayjs";
import UserDataService from "@/services/UserDataService";
import VueSpeedometer from "vue-speedometer";

export default {
  // el: '#app',
  name: "basic",
  components: {
    VueSpeedometer
  },
  data() {
    return {
      //그래프
      // TODO : 오늘 날짜 가져오는 함수
      today: dayjs().format("YYYY-MM-DD"),
      // 체지방률 가져오는 변수
      bodyFatg: 0,
      // 골격근량 가져오는 변수
      muscleg: 0,

      cu: {
        // 체지방률
        bodyFat: 0,
        // 골격근량
        muscleMass: 0,
        // 체중
        weight: 0,
      },
    };
  },
  methods: {
    // 체지방률 메소드
    changeFat() {
      this.bodyFatg = (this.cu.bodyFat / 30.0) * 900;
    },
    // 골격근량 메소드
    // changeMuscle() {
    //   this.muscleg = ((this.cu.muscleMass / 36) * 30.2 * 1.8) * 8;
    // },
    changeMuscle() {
      this.muscleg = (this.cu.muscleMass*(270/this.cu.height)^2)*10;
    },
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
    getUsersById(id){
      UserDataService.getUsersById(id)
          .then((response)=>{
            this.cu.weight= response.data.weight;
            this.cu.bodyFat= response.data.bodyFat;
            this.cu.muscleMass= response.data.muscleMass;
            this.cu.height= response.data.height;
            this.changeFat();
            this.changeMuscle();
            console.log(response.data + "~~~~~~~~~~~~~~~");
          }).catch((e)=>{
        console.log(e+"~~~~~~~~~~~~~~~`");
      })
    },



  }, computed: {
    currentUser() {
      // 공유저장소의 전역변수(공유변수 : user)
      // 자동으로 로그인이 되었으면 loggedIn = true, user객체 있음
      // 아니면 loggedIn = false, user객체 = null
      return this.$store.state.auth.user;
      // return true; // 테스트용
    },
  },
  mounted() {
    this.getUsersById(this.currentUser.id);
    console.log(this.cu)
    console.log(this.bodyFatg)
    console.log(this.muscleg)
  }
};
</script>

<style scoped>
@import "@/assets/css/Basic.css";
</style>