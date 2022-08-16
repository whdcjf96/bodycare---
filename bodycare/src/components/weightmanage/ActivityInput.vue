<template>
  <!-- 화면 시작 -->
  <div class="container-fluid" id="page-top">
    <!-- 화면 바디 시작 -->
    <div class="row">
      <!-- 1번 row 시작 -->
      <div class="col-lg-6 mb-4">
        <div class="card shadow mb-4">
          <div class="card-body">
            <div class="table-responsive">
              <!-- Todo: 수정 시작 #1 -->

              <div>활동명<div class="float-right">활동강도</div></div>
              <!-- 제목(title) 목록 -->
              <ul class="list-group">
                <li
                    class="list-group-item"
                    :class="{ active: index == currentIndex }"
                    v-for="(activitie, index) in activities"
                    :key="index"
                    @click="setActiveActivity(activitie,index)"
                >
                  <div>{{ activitie.activity }}<div class="float-right">{{ activitie.intensity }}</div></div>
                </li>
              </ul>
              <!--    Todo : page 바 태그 추가 -->
              <!-- Todo : 수정 끝 #1 -->

              <!-- Todo : page 바 태그 추가 -->
              <div class="col-md-12">
                <div class="mb-3">
                  Items per Page:
                  <select
                      v-model="pageSize"
                      @change="handlePageSizeChange($event)"
                  >
                    <option v-for="size in pageSizes" :key="size" :value="size">
                      {{ size }}
                    </option>
                  </select>
                </div>

                <!--      Todo : page bar 추가-->
                <b-pagination
                    v-model="page"
                    :total-rows="count"
                    :per-page="pageSize"
                    prev-text="Prev"
                    next-text="Next"
                    @change="handlePageChange"
                >
                </b-pagination>
              </div>
            </div>
          </div>
        </div>
      </div>
      <!-- 1번 row 끝-->

      <!-- 2번 row 시작-->
      <div class="col-lg-6 mb-4">
        <!-- 활동창 시작 -->
        <div class="card shadow mb-4">
          <div class="card-body text-center">
            <div class="text-left">
              <h6>활동</h6>
            </div>
            <!-- 상세 정보를 보여주는 div 시작 -->
            <div class="col-md-6">

              <!-- <label for="activity" class="form-label">활동 명</label>
              <input
                  type="text"
                  class="form-control"
                  id="activity"
                  name="activity"
                  v-model="currentActivity.activity"
              > -->
              <!-- currentTutorial != null 이면 -->
              <div v-if="currentActivity">

                <h2>
                  {{ inputActivities.activity }}
                </h2>
              </div>
              <!--               currentTutorial == null 이면-->
              <div v-else>
                <br />
                <h2>선택하세요...</h2>
              </div>

            </div>
            <!-- 상세 정보를 보여주는 div 끝 -->
          </div>
        </div>
        <!-- 활동창 끝 -->

        <!-- 시간창 시작 -->
        <div class="card shadow mb-4">
          <div class="card-body">
            <div class="text-left">
              <h6>시간</h6>
            </div>
            <input class="text-center"
                   v-model="inputActivities.activityTime"/>
            <div class="float-right">
              {{inputActivities.activityTime}}hours
            </div>
          </div>
        </div>
        <!-- 시간창 끝 -->
      </div>
      <!-- 2번 row 끝-->
    </div>
    <!-- 화면 바디 끝 -->

    <!-- 취소버튼 -->
    <router-link to="/activityManage">
      <button class="btn btn-danger float-left">돌아가기</button>
    </router-link>

    <!-- 저장 후 추가 버튼 -->
    <button class="btn btn-primary float-right" @click="saveActivity">저장 후 추가</button>
  </div>
</template>

<script>
import ActivityDataService from "@/services/ActivityDataService";
import dayjs from "dayjs";
export default {
  name: "activityInput",
  data() {
    return {
      today: dayjs().format("YYYY-MM-DD"),
      activities: [],
      currentActivity: null,
      currentIndex: -1,
      searchTitle: "",
      page: 1,
      count: 0,
      pageSize: 3,
      pageSizes: [3, 6],
      inputActivities:{
        id:null,
        activity:"",
        activityTime:0,
        userId : null,
        activityId : null,
        activityDate:"",
        intensity:0
      },
      submitted: false,
    };
  },
  computed:{
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    saveActivity() {
      // console.log(this.userId);
      // console.log(this.activityId);

      // 회원 임시 객체 만들기
      var data = {
        activity: this.inputActivities.activity,
        activityTime: this.inputActivities.activityTime,
        userId:this.inputActivities.userId,
        activityId:this.inputActivities.activityId,
        activityDate:this.inputActivities.activityDate,
        intensity:this.inputActivities.intensity
      };
      // 임시 회원 객체를 서버쪽으로 전달해서 DB에 insert 요청
      console.log(data);
      alert("추가되었습니다!");

      ActivityDataService.create(data)
          // 성공하면 .then으로 데이터가 들어옴
          .then((response) => {

            this.inputActivities.id = response.data.id;
            this.submitted = true; // DB insert 성공
          })
          // 실패하면 .catch로 에러메세지가 들어옴
          .catch((e) => {
            alert(e);
          });
    },
    getRequestParams(searchTitle, page, pageSize) {
      let params = {};

      // // searchTitle 값이 있으면 params객체에 title로 저장
      if (searchTitle) {
        params["activity"] = searchTitle;
      }
      // page 값이 있으면 params객체에 page 저장
      if (page) {
        params["page"] = page - 1;
      }
      // pageSize 값이 있으면 params객체에 size 저장
      if (pageSize) {
        params["size"] = pageSize;
      }

      return params;
    },
    // 모든 회원 조회 서비스 호출
    retrieveActivitys() {
      const params = this.getRequestParams(
          this.searchTitle,
          this.page,
          this.pageSize
      );
      // axios로 spring에 모든 회원 조회 요청
      ActivityDataService.getAll(params)
          // 성공하면 then으로 서버 데이터(response.data)가 들어옴
          .then((response) => {
            const { activities, totalItems } = response.data;
            this.activities = activities; // 객체
            this.count = totalItems; // 총건수

            console.log(response.data);
          })
          // 실패하면 catch로 에러메세지가 들어옴
          .catch((e) => {
            alert(e);
          });
    },
    handlePageChange(value) {
      // 페이지번호 저장
      this.page = value;
      // 다시 데이터 조회
      this.retrieveActivitys();
    },
    // 역할 : 페이지당건수가 변경되면 다시 조회하는 메소드
    handlePageSizeChange(event) {
      // 한 페이지 당 건수 저장
      this.pageSize = event.target.value; // 셀렉트박스 변경시 값 가져옴
      this.page = 1;
      // 다시 데이터 조회
      this.retrieveActivitys();
    },
    refreshList() {
      this.retrieveActivitys();
      this.currentActivity = null;
      this.currentIndex = -1;
    },

    setActiveActivity(activities, index) {

      // this.currentActivity = activities;
      // this.inputActivities.activity = this.currentActivity.activity
      // this.inputActivities.activityId = this.currentActivity.id;
      // this.inputActivities.userId = this.currentUser.id;
      // this.inputActivities.activityDate = this.today;
      // this.inputActivities.intensity = this.currentActivity.intensity;
      // this.currentIndex = index;
      console.log("setActiveActivity");
      this.currentActivity = activities;
      this.inputActivities.activity = activities.activity;
      this.inputActivities.activityId = activities.id;
      this.inputActivities.userId = this.currentUser.id;
      this.inputActivities.activityDate = this.today;
      this.inputActivities.intensity = activities.intensity;
      this.currentIndex = index;
      console.log(this.inputActivities);
    },
  },
  // 최초 화면이 로딩될때(뜰때) 실행되는 이벤트(모든 회원조회가 실행됨)
  mounted() {
    this.retrieveActivitys();

  },
};
</script>

<style>
</style>