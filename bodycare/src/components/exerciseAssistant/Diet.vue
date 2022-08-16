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
          <router-link to="/diet" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>다이어트</span>
          </router-link>
        </li>
        <li class="nav-item">
          <router-link to="/supplement" class="nav-link">
            <i class="fas fa-fw fa-tachometer-alt"></i>
            <span>보충제</span>
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
        <!-- 화면 헤더 시작 -->
        <!-- 현재 날짜 출력 시작 -->
        <!-- TODO : 현재 날짜 출력 -->
        <div class="text-center">
          <h2 class="text-primary">&lt;{{ today }}&gt;</h2>
        </div>
        <!-- 현재 날짜 출력 끝 -->
        <!-- 화면 헤더 끝 -->

        <!--    첫줄-->
        <div class="row mt-3">
          <!--    체중 시작-->
          <div class="col">
            <div class="card shadow mb-4 text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">체중</h5>
              </div>
              <h5 class="card-body">{{ basic.weight }} Kg</h5>
            </div>
          </div>
          <!--    체중 끝-->

          <!--    체지방률 시작-->
          <div class="col">
            <div class="card shadow mb-4  text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">체지방률</h5>
              </div>
              <h5 class="card-body">{{basic.bodyFat}} %</h5>
            </div>
          </div>
          <!--    체지방률 끝-->
        </div>
        <!--    1번 row 끝-->

        <!--    2번 row-->
        <div class="row">
          <!--    원하는 체지방률 시작-->
          <div class="col">
            <div class="card shadow mb-4  text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">
                  원하는 체지방률
                </h5>
              </div>
              <h5 class="card-body">{{basic.fatGoal}} %</h5>
            </div>
          </div>
          <!--    원하는 체지방률 끝-->
          <!--    시작시 줄일 칼로리 시작-->
          <div class="col">
            <div class="card shadow mb-4 text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">
                  시작시 줄일 칼로리
                </h5>
              </div>
              <h5 class="card-body">{{basic.kcalStart}} Kcal</h5>
            </div>
          </div>
          <!--    시작시 줄일 칼로리 끝-->
          <!--    매주 줄일 칼로리 시작-->
          <div class="col">
            <div class="card shadow mb-4 text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">
                  매주 줄일 칼로리
                </h5>
              </div>
              <h5 class="card-body">{{basic.kcalWeekly}} Kcal</h5>
            </div>
          </div>
          <!--    매주 줄일 칼로리 끝-->
        </div>
        <!--    2번 row끝-->

        <!--    3번 row시작-->
        <div class="row">
          <!--    원하는 체지방률일 때의 체중 시작-->
          <div class="col">
            <div class="card shadow mb-4 text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">
                  원하는 체지방률일 때의 체중
                </h5>
              </div>
              <h5 class="card-body">{{wantWeight}} Kg</h5>
            </div>
          </div>
          <!--    원하는 체지방률일 때의 체중 끝-->
          <!--    빼야 할  시작-->
          <div class="col">
            <div class="card shadow mb-4 text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">빼야 할 체중</h5>
              </div>
              <h5 class="card-body">{{minusWeight}} Kg</h5>
            </div>
          </div>
          <!--    빼야 할 체중 끝-->
          <!--    다이어트 기간 시작-->
          <div class="col">
            <div class="card shadow mb-4 text-center">
              <div class="card-header py-3">
                <h5 class="m-0 font-weight-bold text-primary">
                  예상 다이어트 기간
                </h5>
              </div>
              <h5 class="card-body">{{ estDietPeriod }} 일</h5>
            </div>
          </div>
          <!--    다이어트 기간 끝-->
        </div>
        <!--    3번 row 끝-->

        <!--    comment 시작-->
        <div class="row">
          <div class="col">
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">Comment</h6>
              </div>
              <div class="card-body">...</div>
            </div>
          </div>
        </div>
        <!--    comment 끝-->
      </div>
    </div>
  </div>
</template>

<script>
import dayjs from "dayjs";
import UserDataService from "@/services/UserDataService";
export default {
  name: "DietCom",
  data() {
    return {
      // TODO : 오늘 날짜 가져오는 함수
      today: dayjs().format("YYYY-MM-DD"),
      bodyFatg:0,
      muscleg:0,
      basic:{
        bodyFat:0, // 현재체지방률
        muscle:0, // 현재골격근량
        weight:0, // 현재체중
        fatGoal:0, // 원하는 체지방률
        kcalStart:0, // 시작시 뺄 칼로리
        kcalWeekly:0, // 매주 줄일 칼로리

        // Amr:0, // 활동대사량
        // dayKcal:0, // 하루 섭취 칼로리 => 아침 + 점심 + 저녁 + 간식
      }
    };
  },
  computed:{
    currentUser() {
      return this.$store.state.auth.user;
    },
    // 원하는 체지방률일때 체중
    wantWeight(){
      return ((this.basic.weight - ((this.basic.fatGoal / 100 ) * this.basic.weight)) * 10) / 10;
    },
    // 빼야할 체중
    minusWeight() {
      return (((this.basic.fatGoal / 100 ) * this.basic.weight) * 10) / 10;
    },
    // 예상 다이어트 기간
    estDietPeriod() {
      return (((this.minusWeight * 7000) / this.basic.kcalStart) * 10) / 10;
    }

  },
  mounted(){
    console.log("mounted"+this.currentUser.id);
    this.retrieveDiets(this.currentUser.id);
  },
  methods: {
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
    // 모든 회원 조회 서비스 호출
    retrieveDiets(id) {
      // axios로 spring에 모든 회원 조회 요청
      UserDataService.getUsersById(id)
          // 성공하면 then으로 서버 데이터(response.data)가 들어옴
          .then((response) => {
            this.basic = response.data;
            console.log(response.data);
          })
          // 실패하면 catch로 에러메세지가 들어옴
          .catch((e) => {
            alert(e);
          });
    },


  }
};
</script>

<style scoped>
</style>