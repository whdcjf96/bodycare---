<template>
  <!-- 화면 시작 -->
  <div class="container-fluid" id="page-top">


    <!-- 화면 바디 시작 -->
    <div class="row">
      <!-- search 관련 div 시작 -->
      <div class="col-md-8">
        <div class="input-group mb-3">
          <!-- 검색 입력 박스 -->
          <input
              type="text"
              class="form-control"
              placeholder="Search by title"
              v-model="searchTitle"
          />
          <!-- 검색 버튼 -->
          <div class="input-group-append">
            <button
                class="btn btn-outline-secondary"
                type="button"
                @click="
              page = 1;
              retrieveFoods();
            "
            >
              Search
            </button>
          </div>
        </div>
      </div>
      <!-- search 관련 div 끝 -->
      <!-- 1번 row 시작 -->
      <div class="col-lg-6 mb-4">
        <div class="card shadow mb-4">
          <div class="card-body">
            <div class="table-responsive">

              <div class="row">
                <div class="col-6">음식명</div>
                <div class="col">탄수화물</div>
                <div class="col">단백질</div>
                <div class="col">지방</div>
              </div>


              <!-- 제목(title) 목록 -->
              <ul class="list-group">
                <li
                    class="list-group-item"
                    :class="{ active: index == currentIndex }"
                    v-for="(foodInput, index) in diets"
                    :key="index"
                    @click="setActiveFood(foodInput,index)"
                >
                  <div class="row">
                    <div class="col-6">{{ foodInput.title }}</div>
                    <div class="col">{{ foodInput.carbohydrate }}</div>
                    <div class="col">{{ foodInput.protein }}</div>
                    <div class="col">{{ foodInput.fat }}</div>

                  </div>
                </li>
              </ul>


              <!-- 제목(title) 목록 -->


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
              <h6>식품명</h6>
            </div>
            <div class="row">
              <div v-if="currentFood">
                <div class="row">
                  <div class="col">
                    <h2>
                      {{ inputFoods.carbohydrate }}g
                    </h2>
                  </div>
                  <div class="col">
                    <h2>
                      {{ inputFoods.protein }}g
                    </h2>
                  </div>
                  <div class="col">
                    <h2>
                      {{ inputFoods.fat }}g
                    </h2>
                  </div>
                </div>
              </div>
              <!--               currentTutorial == null 이면-->
              <div v-else>
                <div class="row">
                  <div class="col">
                    <h2>
                      0g
                    </h2>
                  </div>
                  <div class="col">
                    <h2>
                      0g
                    </h2>
                  </div>
                  <div class="col">
                    <h2>
                      0g
                    </h2>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- 활동창 끝 -->

        <!-- 시간창 시작 -->
        <div class="card shadow mb-4">
          <div class="card-body">
            <div class="text-left">
              <h6>수량</h6>
            </div>
            <input class="text-center"
                   v-model="inputFoods.quantity"/>
            <div class="float-right">100g 기준</div>
          </div>
        </div>
        <!-- 시간창 끝 -->

        <!-- 아점저창 시작 -->
        <div class="card shadow mb-4">
          <div class="card-body">
            <ul class="navbar-nav">
              <!-- dropdown #1 시작 -->
              <li class="nav-item dropdown mr-4">
                <a
                    class="nav-link dropdown-toggle mr-5"
                    href="#"
                    id="navbarDropdownMenuLink"
                    data-toggle="dropdown"
                    aria-haspopup="true"
                    aria-expanded="false"
                >
                  식사구분
                </a>
                <select v-model="sub" style="width: 100px;" @change="msgBox">
                  <option v-for="(board,index) in list" :key="index" :value="board.cont">
                    {{board.sub}}
                  </option>
                </select>

              </li>
            </ul>
            <!-- dropdown #1 끝 -->
          </div>
        </div>
        <!-- 아점저창 끝 -->
      </div>
      <!-- 2번 row 끝-->
    </div>
    <!-- 화면 바디 끝 -->

    <!-- 취소버튼 -->
    <router-link to="/food">
      <button class="btn btn-danger float-left">돌아가기</button>
    </router-link>

    <!-- 저장 후 추가 버튼 -->
    <button class="btn btn-primary float-right" @click="saveFood">저장 후 추가</button>
  </div>
</template>

<script>
import DietDataService from "@/services/DietDataService";
import dayjs from "dayjs";
export default {
  name: "foodInput",
  data() {
    return {
      today: dayjs().format("YYYY-MM-DD"),
      sub:'default',
      cont:0,
      list:[
        {sub:'아침',cont:0},
        {sub:'점심',cont:1},
        {sub:'저녁',cont:2},
        {sub:'간식',cont:3},
      ],
      diets: [],
      currentFood: null,
      currentIndex: -1,
      searchTitle: "",
      page: 1,
      count: 0,
      pageSize: 5,
      pageSizes: [5, 10],
      inputFoods: {
        id: null,
        title: "",
        carbohydrate: "",
        protein: "",
        fat: "",
        dietTime:0,
        userId: null,
        dietDate:this.today,
        dietId:null,
        quantity:0,
      },
      submitted: false,
    };
  },
  computed: {
    currentUser() {
      return this.$store.state.auth.user;
    }
  },
  methods: {
    msgBox(){
      this.dietTime = this.list;
    },
    saveFood() {
      alert("추가되었습니다!");
      var data = {
        title: this.inputFoods.title,
        quantity:this.inputFoods.quantity,
        dietTime:this.sub,
        userId: this.inputFoods.userId,
        carbohydrate: this.inputFoods.carbohydrate,
        protein: this.inputFoods.protein,
        fat: this.inputFoods.fat,
        dietDate: this.today,
        dietId:this.inputFoods.dietId
      };
      DietDataService.createUserDiet(data)
          // 성공하면 .then으로 데이터가 들어옴
          .then((response) => {
            this.inputFoods.id = response.data.id;
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
        params["title"] = searchTitle;
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
    retrieveFoods() {
      const params = this.getRequestParams(
          this.searchTitle,
          this.page,
          this.pageSize
      );
      // axios로 spring에 모든 회원 조회 요청
      DietDataService.getAllDiets(params)
          // 성공하면 then으로 서버 데이터(response.data)가 들어옴
          .then((response) => {
            const {diets, totalItems} = response.data;
            this.diets = diets; // 객체
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
      this.retrieveFoods();
    },
    // 역할 : 페이지당건수가 변경되면 다시 조회하는 메소드
    handlePageSizeChange(event) {
      // 한 페이지 당 건수 저장
      this.pageSize = event.target.value; // 셀렉트박스 변경시 값 가져옴
      this.page = 1;
      // 다시 데이터 조회
      this.retrieveFoods();
    },
    refreshList() {
      this.retrieveFoods();
      this.currentFood = null;
      this.currentIndex = -1;
    },

    setActiveFood(diets, index) {
      this.currentFood = diets;
      this.currentIndex = index;
      this.inputFoods.title = diets.title;
      this.inputFoods.carbohydrate = diets.carbohydrate;
      this.inputFoods.userId = this.currentUser.id;
      this.inputFoods.fat = diets.fat;
      this.inputFoods.dietTime = this.sub;
      this.inputFoods.protein = diets.protein;
      this.inputFoods.dietDate=this.today;
      this.inputFoods.dietId = diets.id;
    },
  },
  // 최초 화면이 로딩될때(뜰때) 실행되는 이벤트(모든 회원조회가 실행됨)
  mounted() {
    this.retrieveFoods();
  },
};

</script>

<style>
</style>