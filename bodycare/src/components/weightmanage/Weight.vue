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
        <div class="row">
          <!-- Content Column -->
          <!-- TODO : 내용 수정 -->
          <!-- Illustrations -->
          <div class="col-lg-12 mb-4">
            <div class="card shadow mb-4">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary">
                    체중 추적 그래프
                  </h6>
                </div>
                <div class="graph_wrap">
                  <div>
                    <div id="chart">
                      <apexchart
                        type="line"
                        height="300"
                        :options="chartOptions"
                        :series="series"
                      ></apexchart>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>

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
                <label for="weight" class="m-0 font-weight-bold text-primary">
                  체중
                </label>
              </div>
              <div class="card-body text-center">
                <input
                  type="number"
                  id="weight"
                  style="border: none; border-bottom: solid"
                  placeholder="0"
                  required
                  name="weight"
                />

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
                <label for="date" class="m-0 font-weight-bold text-primary">
                  날짜
                </label>
              </div>
              <div class="card-body text-center">
                <input
                  type="text"
                  id="date"
                  style="border: none; border-bottom: solid"
                  placeholder="yy-mm-dd"
                  required
                  name="date"
                />
                <h6 class="float-right"></h6>
              </div>
            </div>
          </div>
        </div>
        <!-- 체지방률 입력창 끝 -->
      </div>

      <!--          아침 점심 저녁 간식 테이블 끝-->
    </div>
  </div>
</template>

<script>
/*eslint-disable*/
import VueApexCharts from "vue-apexcharts";

export default {
  name: "food",
  components: {
    apexchart: VueApexCharts,
  },
  data() {
    return {
      series: [
        {
          name: "체중",
          data: [80, 75, 70, 90, 65],
        },
      ],
      chartOptions: {
        chart: {
          height: 350,
          type: "line",
          dropShadow: {
            enabled: true,
            color: "#000",
            top: 18,
            left: 7,
            blur: 10,
            opacity: 0.2,
          },
          toolbar: {
            show: false,
          },
        },
        colors: ["#77B6EA", "#545454"],
        dataLabels: {
          enabled: true,
        },
        stroke: {
          curve: "smooth",
        },
        grid: {
          borderColor: "#e7e7e7",
          row: {
            colors: ["#f3f3f3", "transparent"], // takes an array which will be repeated on columns
            opacity: 0.5,
          },
        },
        markers: {
          size: 1,
        },
        xaxis: {
          type: "datetime",
          categories: [
            "07/01/2022 GMT",
            "07/02/2022 GMT",
            "07/03/2022 GMT",
            "07/04/2022 GMT",
            "07/05/2022 GMT",
          ],
        },
        yaxis: {
          title: {
            text: "kg",
          },
          min: 5,
          max: 120,
        },
        legend: {
          position: "top",
          horizontalAlign: "right",
          floating: true,
          offsetY: -25,
          offsetX: -5,
        },
      },
    }
  },
  methods: {
        logOut() {
          // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
          this.$store.dispatch("auth/logout");
          // 로그아웃 후 이동할 페이지 지정
          this.$router.push("/");
        },
        //   updateChart() {
        //     const max = 90;
        //     const min = 20;
        //     const newData = this.series[0].data.map(() => {
        //       return Math.floor(Math.random() * (max - min + 1)) + min
        //     })
        //     // In the same way, update the series option
        //     this.series = [{
        //       data: newData
        //     }]
        //   }
    },
}
</script>

<style scoped>
</style>