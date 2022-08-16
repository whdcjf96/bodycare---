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

    <!-- Begin Page Content -->
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
        <ul class="navbar-nav">
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
      <div class="container-fluid" id="page-top">
        <!-- Page Heading -->
        <!-- TODO : 현재 날짜 출력 -->
        <div class="row">
          <div
            class="ma-0 pa-3 col col-10"
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
        <!-- TODO : 내용 수정 -->
        <!-- Content Row -->
        <div class="row">
          <!-- Content Column -->
          <div class="col-lg-10 mb-4">
            <!-- Project Card Example -->
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <!-- TODO : Project -> 활동대사량 이름 수정 -->
                <div class="m-0 font-weight-bold text-primary">
                  섭취할 칼로리
                </div>
              </div>
              <div class="card-body text-center">
                <h1 style="font-weight: bold; display: inline">{{ this.currentUser.amr }}</h1>
                <h5 style="display: inline"> kcal</h5>
              </div>
            </div>
          </div>

          <!-- TODO : 내용 수정 -->
          <div class="col-lg-10 mb-4">
            <!-- Illustrations -->
            <div class="card shadow mb-4">
              <div class="card-header py-3">
                <h6 class="m-0 font-weight-bold text-primary">
                  탄단지 비율 그래프
                </h6>
              </div>
              <div class="card-body">
                <div class="row">
                  <div class="lg-10 ml-4 mr-5">
                    <div>
                      <b-progress :max="max">
                        <b-progress-bar
                          variant="primary"
                          :value="values[0]"
                          animated
                          show-progress
                          class="float-left"
                        >
                          <div>탄</div>
                        </b-progress-bar>
                        <b-progress-bar
                          variant="success"
                          :value="values[1]"
                          animated
                          show-progress
                        >
                          <div>단</div>
                        </b-progress-bar>
                        <b-progress-bar
                          variant="info"
                          :value="values[2]"
                          animated
                          show-progress
                        >
                          <div>지</div>
                        </b-progress-bar>
                      </b-progress>
                      <div id="chart">
                        <apexchart
                          type="bar"
                          height="350"
                          :options="chartOptions"
                          :series="series"
                        ></apexchart>
                      </div>
                    </div>

                    <strong class="tit">Kcal</strong>
                  </div>
                  <!--          ----------------------------->
                  <!-- 체성분 인풋란 -->
                  <div class="row">
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
                            <label
                              for="carbor"
                              class="m-0 font-weight-bold text-primary"
                            >
                              탄수화물 비율
                            </label>
                          </div>
                          <div class="card-body text-center">
                            30

                            <h6 class="float-right">%</h6>
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
                            <label
                              for="weightProtein"
                              class="m-0 font-weight-bold text-primary"
                            >
                              단백질 비율
                            </label>
                          </div>
                          <div class="card-body text-center">
                            40
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
                            <label
                              for="kcalCon"
                              class="m-0 font-weight-bold text-primary"
                            >
                              지방 비율
                            </label>
                          </div>
                          <div class="card-body text-center">
                            30
                            <h6 class="float-right">%</h6>
                          </div>
                        </div>
                      </div>
                      <!-- 골격근량 입력창 끝-->
                    </div>
                    <!--///////////////////////////////////////-->

                    <!-- 하루 섭취할 칼로리 시작 -->
                    <div class="row">
                      <div class="col-lg-12 mb-auto">
                        <div class="card-header py-10">
                          <div class="row font-weight-bold text-primary">
                            <h4 class="col-lg-4">아침</h4>
                            <h4 class="col-lg-2 text-right">칼로리</h4>
                            <h4 class="col-lg-2 text-center">탄</h4>
                            <h4 class="col-lg-2 text-center">단</h4>
                            <h4 class="col-lg-2 text-center">지</h4>
                          </div>
                        </div>
                        <div class="card-body text-left">
                          <h5>
                            <div class="row">
                              <div class="col-lg-6 text-right">
                                {{
                                  Math.round(
                                    testSum2[0] * 4 +
                                      testSum2[1] * 4 +
                                      testSum2[2] * 9
                                  )
                                }}kcal
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[0] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[1] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[2] * 10) / 10 }}
                              </div>
                            </div>
                          </h5>
                          <!-- 아침 밥 시작 -->
                          <div v-for="(diet, index) in diets" :key="index">
                            <div v-if="diet.dietTime == 0">
                              <div
                                class="card shadow float-left"
                                style="width: 12rem; height: 11rem"
                              >
                                <div class="card-body text-left">
                                  <div class="row">
                                    <div class="col-lg-10">
                                      {{ diet.title }}
                                    </div>
                                    <div class="col-lg-2">
                                      <div
                                        class="
                                          float-right
                                          btn btn-sm btn-danger
                                        "
                                        @click="setActiveDiet(diet, index)"
                                      >
                                        X
                                      </div>
                                    </div>
                                  </div>
                                  <h5>X{{ diet.quantity }}</h5>
                                  <h6>
                                    <div class="row">
                                      <div class="col-lg-5">100g</div>
                                      <div class="col-lg-7">
                                        {{
                                          Math.round(
                                            (diet.carbohydrate * 4 +
                                              diet.protein * 4 +
                                              diet.fat * 9) *
                                              10
                                          ) / 10
                                        }}Kcal
                                      </div>
                                    </div>
                                  </h6>
                                  <div class="row">
                                    <div class="col-lg-4">탄</div>
                                    <div class="col-lg-4">단</div>
                                    <div class="col-lg-4">지</div>
                                  </div>
                                  <div class="row">
                                    <div class="col-lg-4">
                                      {{ diet.carbohydrate }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.protein }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.fat }}
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <!-- 아침 밥 끝 -->
                        </div>
                      </div>
                      <div class="col-lg-12 mb-auto">
                        <div class="card-header py-10">
                          <div class="row font-weight-bold text-primary">
                            <h4 class="col-lg-4">점심</h4>
                            <h4 class="col-lg-2 text-right">칼로리</h4>
                            <h4 class="col-lg-2 text-center">탄</h4>
                            <h4 class="col-lg-2 text-center">단</h4>
                            <h4 class="col-lg-2 text-center">지</h4>
                          </div>
                        </div>
                        <div class="card-body text-left">
                          <h5>
                            <div class="row">
                              <div class="col-lg-6 text-right">
                                {{
                                  Math.round(
                                    testSum2[3] * 4 +
                                      testSum2[4] * 4 +
                                      testSum2[5] * 9
                                  )
                                }}kcal
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[3] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[4] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[5] * 10) / 10 }}
                              </div>
                            </div>
                          </h5>
                          <!-- 점심 밥 시작 -->
                          <div v-for="(diet, index) in diets" :key="index">
                            <div v-if="diet.dietTime == 1">
                              <div
                                class="card shadow float-left"
                                style="width: 12rem; height: 11rem"
                              >
                                <div class="card-body text-left">
                                  <div class="row">
                                    <div class="col-lg-10">
                                      {{ diet.title }}
                                    </div>
                                    <div class="col-lg-2">
                                      <div
                                        class="
                                          float-right
                                          btn btn-sm btn-danger
                                        "
                                        @click="setActiveDiet(diet, index)"
                                      >
                                        X
                                      </div>
                                    </div>
                                  </div>
                                  <h5>X{{ diet.quantity }}</h5>
                                  <h6>
                                    <div class="row">
                                      <div class="col-lg-5">100g</div>
                                      <div class="col-lg-7">
                                        {{
                                          Math.round(
                                            (diet.carbohydrate * 4 +
                                              diet.protein * 4 +
                                              diet.fat * 9) *
                                              10
                                          ) / 10
                                        }}Kcal
                                      </div>
                                    </div>
                                  </h6>
                                  <div class="row">
                                    <div class="col-lg-4">탄</div>
                                    <div class="col-lg-4">단</div>
                                    <div class="col-lg-4">지</div>
                                  </div>
                                  <div class="row">
                                    <div class="col-lg-4">
                                      {{ diet.carbohydrate }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.protein }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.fat }}
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <!-- 점심 밥 끝 -->
                        </div>
                      </div>
                      <div class="col-lg-12 mb-auto">
                        <div class="card-header py-10">
                          <div class="row font-weight-bold text-primary">
                            <h4 class="col-lg-4">저녁</h4>
                            <h4 class="col-lg-2 text-right">칼로리</h4>
                            <h4 class="col-lg-2 text-center">탄</h4>
                            <h4 class="col-lg-2 text-center">단</h4>
                            <h4 class="col-lg-2 text-center">지</h4>
                          </div>
                        </div>
                        <div class="card-body text-left">
                          <h5>
                            <div class="row">
                              <div class="col-lg-6 text-right">
                                {{
                                  Math.round(
                                    testSum2[6] * 4 +
                                      testSum2[7] * 4 +
                                      testSum2[8] * 9
                                  )
                                }}kcal
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[6] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[7] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[8] * 10) / 10 }}
                              </div>
                            </div>
                          </h5>
                          <!-- 아침 밥 시작 -->
                          <div v-for="(diet, index) in diets" :key="index">
                            <div v-if="diet.dietTime == 2">
                              <div
                                class="card shadow float-left"
                                style="width: 12rem; height: 11rem"
                              >
                                <div class="card-body text-left">
                                  <div class="row">
                                    <div class="col-lg-10">
                                      {{ diet.title }}
                                    </div>
                                    <div class="col-lg-2">
                                      <div
                                        class="
                                          float-right
                                          btn btn-sm btn-danger
                                        "
                                        @click="setActiveDiet(diet, index)"
                                      >
                                        X
                                      </div>
                                    </div>
                                  </div>
                                  <h5>X{{ diet.quantity }}</h5>
                                  <h6>
                                    <div class="row">
                                      <div class="col-lg-5">100g</div>
                                      <div class="col-lg-7">
                                        {{
                                          Math.round(
                                            (diet.carbohydrate * 4 +
                                              diet.protein * 4 +
                                              diet.fat * 9) *
                                              10
                                          ) / 10
                                        }}Kcal
                                      </div>
                                    </div>
                                  </h6>
                                  <div class="row">
                                    <div class="col-lg-4">탄</div>
                                    <div class="col-lg-4">단</div>
                                    <div class="col-lg-4">지</div>
                                  </div>
                                  <div class="row">
                                    <div class="col-lg-4">
                                      {{ diet.carbohydrate }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.protein }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.fat }}
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <!-- 아침 밥 끝 -->
                        </div>
                      </div>
                      <div class="col-lg-12 mb-auto">
                        <div class="card-header py-10">
                          <div class="row font-weight-bold text-primary">
                            <h4 class="col-lg-4">간식</h4>
                            <h4 class="col-lg-2 text-right">칼로리</h4>
                            <h4 class="col-lg-2 text-center">탄</h4>
                            <h4 class="col-lg-2 text-center">단</h4>
                            <h4 class="col-lg-2 text-center">지</h4>
                          </div>
                        </div>
                        <div class="card-body text-left">
                          <h5>
                            <div class="row">
                              <div class="col-lg-6 text-right">
                                {{
                                  Math.round(
                                    testSum2[9] * 4 +
                                      testSum2[10] * 4 +
                                      testSum2[11] * 9
                                  )
                                }}kcal
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[9] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[10] * 10) / 10 }}
                              </div>
                              <div class="col-lg-2 text-center">
                                {{ Math.round(testSum2[11] * 10) / 10 }}
                              </div>
                            </div>
                          </h5>
                          <!-- 아침 밥 시작 -->
                          <div v-for="(diet, index) in diets" :key="index">
                            <div v-if="diet.dietTime == 3">
                              <div
                                class="card shadow float-left"
                                style="width: 12rem; height: 11rem"
                              >
                                <div class="card-body text-left">
                                  <div class="row">
                                    <div class="col-lg-10">
                                      {{ diet.title }}
                                    </div>
                                    <div class="col-lg-2">
                                      <div
                                        class="
                                          float-right
                                          btn btn-sm btn-danger
                                        "
                                        @click="setActiveDiet(diet, index)"
                                      >
                                        X
                                      </div>
                                    </div>
                                  </div>
                                  <h5>X{{ diet.quantity }}</h5>
                                  <h6>
                                    <div class="row">
                                      <div class="col-lg-5">100g</div>
                                      <div class="col-lg-7">
                                        {{
                                          Math.round(
                                            (diet.carbohydrate * 4 +
                                              diet.protein * 4 +
                                              diet.fat * 9) *
                                              10
                                          ) / 10
                                        }}Kcal
                                      </div>
                                    </div>
                                  </h6>
                                  <div class="row">
                                    <div class="col-lg-4">탄</div>
                                    <div class="col-lg-4">단</div>
                                    <div class="col-lg-4">지</div>
                                  </div>
                                  <div class="row">
                                    <div class="col-lg-4">
                                      {{ diet.carbohydrate }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.protein }}
                                    </div>
                                    <div class="col-lg-4">
                                      {{ diet.fat }}
                                    </div>
                                  </div>
                                </div>
                              </div>
                            </div>
                          </div>
                          <!-- 아침 밥 끝 -->
                        </div>
                      </div>
                    </div>

                    <div class="row">
                      <div class="col-lg-8 mb-auto">
                        <div class="card-header py-10"></div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- 추가하기버튼 시작 -->
              <router-link to="/foodInput">
                <button class="btn btn-primary float-left">추가하기</button>
              </router-link>
              <!-- 추가하기버튼 끝 -->
            </div>
          </div>
        </div>
        <!--          아침 점심 점심 저녁 테이블 끝-->
      </div>
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
import dayjs from "dayjs";
import VueApexCharts from "vue-apexcharts";
import DietDataService from "@/services/DietDataService";
import UserDataService from "@/services/UserDataService";

export default {
  name: "food",
  components: {
    apexchart: VueApexCharts,
  },
  // props: ["nameOfChild"],
  data: function () {
    return {
      user: [],
      // 그래프에서 쓸 값들
      series: [
        {
          name: "아침",
          data: [0, 0, 0],
        },
        {
          name: "점심",
          data: [0, 0, 0],
        },
        {
          name: "점심",
          data: [0, 0, 0],
        },
        {
          name: "저녁",
          data: [0, 0, 0],
        },
        {
          name: "부족한 양" + "",
          data: [0, 0, 0],
        },
      ],

      chartOptions: {
        chart: {
          type: "bar",
          height: 350,
          stacked: true,
          toolbar: {
            show: false,
          },
          zoom: {
            enabled: true,
          },
        },

        responsive: [
          {
            breakpoint: 480,
            options: {
              legend: {
                position: "bottom",
                offsetX: -10,
                offsetY: 0,
              },
            },
          },
        ],

        plotOptions: {
          bar: {
            horizontal: false,
            borderRadius: 10,
            barHeight: "70%",
          },
        },

        xaxis: {
          type: "category",
          categories: ["탄수화물", "단백질", "지방"],
          labels: {
            style: {
              fontWeight: "1000",
              fontSize: "15px",
            },
          },
        },

        legend: {
          position: "right",
          offsetY: 40,
          markers: {
            width: 10,
            height: 10,
            strokeWidth: 0,
            strokeColor: "#fff",
            fillColors: ["#4375DB", "#6799FF", "#8BBDFF", "#AFE1FF", "#8C8C8C"],
          },
        },

        fill: {
          colors: ["#4375DB", "#6799FF", "#8BBDFF", "#AFE1FF", "#8C8C8C"],
          opacity: 1,
        },
      },
      // TODO : 오늘 날짜 가져오는 함수
      today: dayjs().format("YYYY-MM-DD"),
      // TODO : 그래프 위 막대 그래프 수치
      values: [30, 40, 30],
      max: 100,

      // userId:this.currentUser.id,
      // dietDate:this.today,
      // 하루 섭취칼로리 값들
      diets: [
        {
          userId:"",
          title: "",
          kcal: 0,
          carbohydrate: 0,
          protein: 0,
          fat: 0,
          id: 0,
          dietDate: "",
          dietTime: 0,
          quantity: 0,
          
        },
      ],
      amr:{
        mr:0
      },
      sum: {
        carsum: 0,
        prosum: 0,
        fatsum: 0,
        carsum1: 0,
        prosum1: 0,
        fatsum1: 0,
        carsum2: 0,
        prosum2: 0,
        fatsum2: 0,
        carsum3: 0,
        prosum3: 0,
        fatsum3: 0,
      },
      testSum2: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
      chartData: {
        labels: ["탄수화물", "단백질", "지방"],
        datasets: [
          {
            label: "Kcal",
            backgroundColor: [
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 159, 64, 0.2)",
              "rgba(75, 192, 192, 0.2)",
            ],
            borderColor: [
              "rgb(54, 162, 235)",
              "rgb(255, 159, 64)",
              "rgb(75, 192, 192)",
            ],
            borderWidth: 1,
            data: [100, 90, 80],
          },
        ],
      },
    };
  },
  mounted() {
    this.retrieveFoods(this.currentUser.id, this.today);
    this.selectAmr(this.currentUser.id);
  },
  methods: {
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
    retrieveFoods(userId, dietDate) {
      // const params = this.getRequestParams(userId, dietDate);
      // axios로 spring에 모든 회원 조회 요청
      DietDataService.getUserDietById(userId, dietDate)
        // 성공하면 then으로 서버 데이터(response.data)가 들어옴
        .then((response) => {
          console.log("response" + dietDate);
          const diets = response.data;
          this.diets = diets; // 객체
          this.sum = this.carSum(diets);
          for (var i = 0; i < this.testSum(diets).length; i++) {
            this.testSum2[i] = this.testSum(diets)[i];
          };
          this.series[0].data = this.carSum2(diets);
        })
        // 실패하면 catch로 에러메세지가 들어옴
        .catch((e) => {
          alert(e);
        });
    },
    // selectAmr(id) {
    //   UserDataService.getUsersById(id)
    //   .then((response) => {
    //     this.amr = response.data;
    //   })
    //   .catch((e) => {
    //       alert(e);
    //     });
    // },
    getRequestParams(userId, dietDate) {
      let params = {};

      // // searchTitle 값이 있으면 params객체에 title로 저장
      if (userId) {
        params["userId"] = userId;
      }
      // page 값이 있으면 params객체에 page 저장
      if (dietDate) {
        params["dietDate"] = dietDate;
      }

      return params;
    },
    carSum(diets) {
      var carsum = 0;
      var prosum = 0;
      var fatsum = 0;
      var carsum1 = 0;
      var prosum1 = 0;
      var fatsum1 = 0;
      var carsum2 = 0;
      var prosum2 = 0;
      var fatsum2 = 0;
      var carsum3 = 0;
      var prosum3 = 0;
      var fatsum3 = 0;
      for (var i = 0; i < diets.length; i++) {
        if (diets[i].dietTime == 0) {
          carsum += diets[i].carbohydrate;
          prosum += diets[i].protein;
          fatsum += diets[i].fat;
        } else if (diets[i].dietTime == 1) {
          carsum1 += diets[i].carbohydrate;
          prosum1 += diets[i].protein;
          fatsum1 += diets[i].fat;
        } else if (diets[i].dietTime == 2) {
          carsum2 += diets[i].carbohydrate;
          prosum2 += diets[i].protein;
          fatsum2 += diets[i].fat;
        } else if (diets[i].dietTime == 3) {
          carsum3 += diets[i].carbohydrate;
          prosum3 += diets[i].protein;
          fatsum3 += diets[i].fat;
        }
      }
      var sum = [
        carsum,
        prosum,
        fatsum,
        carsum1,
        prosum1,
        fatsum1,
        carsum2,
        prosum2,
        fatsum2,
        carsum3,
        prosum3,
        fatsum3,
      ];
      return sum;
    },
    carSum2(diets) {
      var carsum = 0;
      var prosum = 0;
      var fatsum = 0;
      for (var i = 0; i < diets.length; i++) {
        carsum += diets[i].carbohydrate;
        prosum += diets[i].protein;
        fatsum += diets[i].fat;
      }
      var sum = [Math.round(carsum*10)/10, Math.round(prosum*10)/10, Math.round(fatsum*10)/10];
      return sum;
    },
    setActiveDiet(saveDiet, index) {
      this.diets.id = saveDiet.id;
      this.diets.userId=saveDiet.userId;
      this.removeDiets(this.diets.userId,this.diets.id);
    },
    removeDiets(userId,id) {
      DietDataService.deleteDiet(userId,id)
        .then((response) => {
          this.$router.go();
        })
        .catch((e) => {
          alert(e);
        });
    },
    testSum(diets) {
      var carsum = 0;
      var prosum = 0;
      var fatsum = 0;
      var carsum1 = 0;
      var prosum1 = 0;
      var fatsum1 = 0;
      var carsum2 = 0;
      var prosum2 = 0;
      var fatsum2 = 0;
      var carsum3 = 0;
      var prosum3 = 0;
      var fatsum3 = 0;
      for (var i = 0; i < diets.length; i++) {
        if (diets[i].dietTime == 0) {
          carsum += diets[i].carbohydrate;
          prosum += diets[i].protein;
          fatsum += diets[i].fat;
        } else if (diets[i].dietTime == 1) {
          carsum1 += diets[i].carbohydrate;
          prosum1 += diets[i].protein;
          fatsum1 += diets[i].fat;
        } else if (diets[i].dietTime == 2) {
          carsum2 += diets[i].carbohydrate;
          prosum2 += diets[i].protein;
          fatsum2 += diets[i].fat;
        } else if (diets[i].dietTime == 3) {
          carsum3 += diets[i].carbohydrate;
          prosum3 += diets[i].protein;
          fatsum3 += diets[i].fat;
        }
      }
      var testSum2 = [
        carsum,
        prosum,
        fatsum,
        carsum1,
        prosum1,
        fatsum1,
        carsum2,
        prosum2,
        fatsum2,
        carsum3,
        prosum3,
        fatsum3,
      ];
      return testSum2;
    },
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    },
  },
  // 카드 안의 열량의 합
};
</script>

<style scoped>
ul {
  list-style: none;
}

.graph_wrap {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
}

.graph_wrap .tit {
  font-size: 16px;
  font-weight: 500;
  color: #333333;
}

.graph {
  position: relative;
  height: 385px;
  margin-top: 15px;
}

.graph .y-axis {
  position: absolute;
  width: 100%;
  height: 100%;
  z-index: 1;
}

.graph .y-axis > li {
  position: relative;
  width: calc(100% - 20px);
  height: calc(100% / 8);
  margin-left: 20px;
  border-top: 1px solid #8c8c8c;
  text-align: left;
}

.graph .y-axis > li span {
  position: absolute;
  top: -7px;
  left: -20px;
  font-size: 10px;
  line-height: 1;
}

.graph .x-axis {
  position: absolute;
  display: flex;
  bottom: -14px;
  left: 20px;
  width: calc(100% - 20px);
  justify-content: space-around;
  text-align: center;
  z-index: 2;
}

.graph .x-axis > li {
  font-size: 10px;
}

.graph .bar {
  display: flex;
  position: absolute;
  left: 20px;
  bottom: 16px;
  width: calc(100% - 20px);
  height: calc(100% - 16px);
  justify-content: space-around;
  align-items: flex-end;
  text-align: center;
  z-index: 3;
}

.graph .bar > li {
  width: 100%;
}

.graph .bar > li span {
  display: inline-block;
  max-width: 80px;
  width: 100%;
  height: calc(100% + 10px);
  background: #f1cb7e;
}

.graph .bar:before {
  content: "";
  position: absolute;
  top: -2px;
  left: 3px;
  height: calc(100% + 4px);
  width: 1px;
  background: #8c8c8c;
}

.add {
  padding: 30px;
  border: 2px solid #ccc;
  height: 100px;
  background-color: white;
}

/*tr,td,th {
/*  padding: 30px;*/
/*  border: 2px solid #ccc;*/
/*  height: 100px;*/
/*  background-color: white;*/

/*}*/
.underscore_zero {
  width: 200px;
  background-color: white;
}

.underscore_one {
  width: 200px;
  border-bottom: 5px solid skyblue;
}

.underscore_two {
  width: 200px;
  border-bottom: 5px solid #ffa500;
}

.underscore_three {
  width: 200px;
  border-bottom: 5px solid #66cdaa;
}

.edd {
  text-indent: 100px;
  background-color: white;
}

.title {
  font-weight: bold;
  text-indent: 30px;
  font-size: 20px;
}

/*.one{*/
/*  padding: 20px;*/
/*  border: none;*/
/*  height: 100px;*/
/*  background-color: white;*/
/*  line-height:0.1px;  */

/*}*/

.content {
  position: relative;
}

.carbohydrate {
  text-decoration: underline;
  text-underline-position: under;
  color: blue;
}

.thh {
  font-size: large;
}

body {
  padding: 1rem;
}
</style>