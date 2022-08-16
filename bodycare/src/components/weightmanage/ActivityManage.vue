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
        <!-- Nav Item - ActivityManage -->
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
        <ul class="font-weight-bold navbar-nav">
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
        <!-- 화면 헤더 시작 -->
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
            <span>&lt; </span>{{ today }}<span c> &gt;</span>
          </div>
        </div>
        <!-- 현재 날짜 출력 끝 -->
        <!-- 화면 헤더 끝 -->

        <!-- 화면 바디 시작 -->
        <div class="row">
          <!-- 활동대사량 시작 -->
          <!-- TODO : 활동 대사량 가로길이 6 -> 12 -->
          <div class="col-lg-12 mb-4">
            <div class="card shadow mb-4">
              <!-- 활동대사량 제목부분 -->
              <div class="card-header py-3">
                <div class="m-0 font-weight-bold text-primary">
                  <!-- TODO : 활동대사량 제목부분에 기초대사량 추가 -->

                  <div class="row">
                    <div class="col-lg-6 m-0 font-weight-bold text-primary">활동대사량</div>
                  <div class="col-lg-6 m-0 font-weight-bold text-primary text-right"
                    style="display: inline"
                  >
                    기초대사량 :
                    <h4 style="font-weight: bold; display: inline">
                      {{ bmr }}
                    </h4>
                    kcal
                  </div>
                  </div>
                </div>
              </div>
              <!-- 활동대사량 바디부분 -->
              <div class="card-body text-center">
                <button class="btn btn-primary"
                @click="updateAmr">저장</button>
                <h2 class="float-center font-weight-bold">
                  {{ amr }}
                  <!--                  <Food :nameOfChild="amr"></Food>-->
                </h2>
                <h6 class="float-right">kcal</h6>
              </div>
            </div>
          </div>
          <!-- 활동대사량 끝 -->

          <!-- 총 활동 시간 시작 -->
          <!-- TODO : 총 활동 시간 가로길이 6 -> 8 -->
          <div class="col-lg-8 mb-4">
            <div class="card shadow mb-4">
              <!-- 총 활동 시간 제목부분 -->
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">
                  총 활동 {{ stayTime }} 시간(24시간 기준)
                </h6>
                <!-- 활동을 선택하지 않으면 부족 -->
                <h6 class="m-0 font-weight-bold text-primary">
                  활동 정보 {{ 24 - stayTime }}시간 부족
                </h6>
              </div>
              <!-- 총 활동 시간 바디부분 -->
              <div class="card-body">
                <div class="table-responsive">
                  <table
                    class="table"
                    id="dataTable"
                    width="100%"
                    cellspacing="0"
                  >
                    <thead>
                      <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Time</th>
                        <th scope="col">활동강도</th>
                      </tr>
                    </thead>
                    <tbody>
                      <tr
                        v-for="(saveActivity, index) in saveActivities"
                        :key="index"
                      >
                        <td>{{ saveActivity.activity }}</td>
                        <td>{{ saveActivity.activityTime }}</td>
                        <td>{{ saveActivity.intensity }}</td>
                        <td>
                          <button
                            class="btn btn-danger"
                            @click="setActiveActivity(saveActivity, index)"
                          >
                            X
                          </button>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <!-- 총 활동 시간 끝 -->

          <!-- 코멘트 시작 -->
          <!-- TODO : 코멘트 가로길이 6 -> 12 -->
          <div class="col-lg-4 mb-4">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">comment</h6>
              </div>
              <div class="card-body"></div>
            </div>
          </div>
          <!-- 코멘트 끝 -->
        </div>
        <!-- 화면 바디 끝 -->

        <!-- 추가하기버튼 시작 -->
        <router-link to="/activityInput">
          <button class="btn btn-primary float-right">추가하기</button>
        </router-link>
        <!-- 추가하기버튼 끝 -->
      </div>
      <!-- 화면 전체 끝 -->
    </div>
  </div>
</template>

<script>
// 오늘 날짜를 불러오는 함수 임포트
import dayjs from "dayjs";
import ActivityDataService from "@/services/ActivityDataService";
import UserDataService from "@/services/UserDataService";
import Food from "@/components/weightmanage/Food";
export default {
  /* eslint-disable */
  name: "activityManage",
  components: {
    Food,
  },
  data() {
    return {
      // TODO : 오늘 날짜 가져오는 함수
      today: dayjs().format("YYYY-MM-DD"),
      saveActivities: [],
      id: 0,
      stayTime: 0.0,
      cu: {},
    };
  },
  methods: {
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
    // amrProps(){
    //   return this.amr;
    // },
    // 모든 회원 조회 서비스 호출
    retrieveActivitys(id) {
      // axios로 spring에 모든 회원 조회 요청
      ActivityDataService.getUserActivities(id)
        // 성공하면 then으로 서버 데이터(response.data)가 들어옴
        .then((response) => {
          this.saveActivities = response.data;
          for (var i = 0; i < this.saveActivities.length; i++) {
            this.stayTime += this.saveActivities[i].activityTime;
          }
        })
        // 실패하면 catch로 에러메세지가 들어옴
        .catch((e) => {
          alert(e);
        });
    },
    // (활동 목록 삭제)
    removeActivitys(id) {
      ActivityDataService.delete(id)
        .then((response) => {
          this.$router.go();
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // updateAmr() {
    //   // this.cu.amr = this.amr;
    //   console.log(this.amr);
    //   console.log(this.cu);
    //   UserDataService.updateAMR(this.currentUser.id,this.cu)
    //     .then((response) => {
    //       console.log(response.data);
    //     })
    //     .catch((e) => {
    //       // console.log("fdsafdsafdafdasdf")
    //       console.log(e);
    //     });
    // },
    updateAmr() {
      this.currentUser.amr = this.amr;
      // UserDataService.updateAMR(this.currentUser.id,)
      //     .then((response) => {
      //       // this.cu = response.data;
      //       // this.cu.amr = 1900;
      //       console.log("성공");
      //     })
      //     .catch((e) => {
      //       console.log(e);
      //     });
    },
    setActiveActivity(saveActivity, index) {
      this.id = saveActivity.id;
      this.removeActivitys(this.id);
    },
    getUsersById(id) {
      UserDataService.getUsersById(id)
        .then((response) => {
          this.cu = response.data;
          // this.cu.amr = 1900;
          console.log(this.cu);
        })
        .catch((e) => {
          console.log(e);
        });
    },
    // chamr(){
    //   this.$router.push("/food/" + this.amr)
    // }
  },
  computed: {
    // 유저 정보
    currentUser() {
      return this.$store.state.auth.user;
    },
    bmr() {
      return (
        Math.round(
          (21.6 * (this.cu.weight * (1 - this.cu.bodyFat * 0.01)) + 370) * 10
        ) / 10
      );
    },
    amr() {
      var result = 0;
      for (var i = 0; i < this.saveActivities.length; i++) {
        result +=
          this.saveActivities[i].activityTime *
          this.saveActivities[i].intensity;
      }
      var result2 = result / this.stayTime;
      result2 *= this.bmr;
      return Math.round(result2 * 10) / 10;
    },
  },
  mounted() {
    this.retrieveActivitys(this.currentUser.id);
    this.getUsersById(this.currentUser.id);
  },
};
</script>

<style scoped>
ul {
  list-style: none;
}
</style>