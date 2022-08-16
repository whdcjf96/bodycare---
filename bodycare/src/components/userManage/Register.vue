<template>
  <div class="container">
    <div class="card o-hidden border-0 shadow-lg my-5">
      <div class="card-body p-0">
        <!-- Nested Row within Card Body -->
        <div class="row">
          <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
          <div class="col-lg-7">
            <div class="p-5">
              <div class="text-center">
                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
              </div>
              <div v-if="!successful">
                <form class="user" @submit.prevent="handleRegister">
                  <div class="form-group">
                    <label for="name">이름</label>
                    <input
                        type="text"
                        class="form-control form-control-user"
                        id="name"
                        placeholder="Name"
                        v-model="user.name"
                        v-validate="'required|min:3|max:20'"
                        name="name"
                    />
                    <div
                        v-if="errors.has('name') && submitted"
                        class="alert-danger"
                    >
                      {{ errors.first("name") }}
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="email">이메일</label>
                    <input
                        type="email"
                        class="form-control form-control-user"
                        id="email"
                        placeholder="Email Address"
                        v-model="user.email"
                        v-validate="'required|max:50'"
                        name="email"
                    />
                    <div
                        v-if="errors.has('email') && submitted"
                        class="alert-danger"
                    >
                      {{ errors.first("email") }}
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="password">비밀번호</label>

                    <input
                        type="password"
                        class="form-control form-control-user"
                        id="password"
                        placeholder="Password"
                        v-model="user.password"
                        v-validate="'required|min:6|max:40'"
                        name="password"
                    />
                    <div
                        v-if="errors.has('password') && submitted"
                        class="alert-danger"
                    >
                      {{ errors.first("password") }}
                    </div>
                  </div>
                  <div class="row">
                    <div class="col">
                      <div class="form-group">
                        <label for="height">키</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="height"
                            placeholder="height"
                            v-model="user.height"
                            v-validate="'required|max:200'"
                            name="height"
                        />
                        <div
                            v-if="errors.has('height') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("height") }}
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="form-group">
                        <label for="age">나이</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="age"
                            placeholder="age"
                            v-model="user.age"
                            v-validate="'required|max:100'"
                            name="age"
                        />
                        <div
                            v-if="errors.has('age') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("age") }}
                        </div>
                      </div>
                    </div>
                  </div>
                  <!--                  ----------------------------------------->
                  <div class="row">
                    <div class="col">
                      <div class="form-group">
                        <label for="weight">체중</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="weight"
                            placeholder="weight"
                            v-model="user.weight"
                            v-validate="'required|max:200'"
                            name="weight"
                        />
                        <div
                            v-if="errors.has('weight') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("weight") }}
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="form-group">
                        <label for="bodyFat">체지방</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="bodyFat"
                            placeholder="bodyFat"
                            v-model="user.bodyFat"
                            v-validate="'required|max:100'"
                            name="bodyFat"
                        />
                        <div
                            v-if="errors.has('bodyFat') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("bodyFat") }}
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="form-group">
                        <label for="muscleMass">골격근량</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="muscleMass"
                            placeholder="muscleMass"
                            v-model="user.muscleMass"
                            v-validate="'required|max:100'"
                            name="muscleMass"
                        />
                        <div
                            v-if="errors.has('muscleMass') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("muscleMass") }}
                        </div>
                      </div>
                    </div>
                  </div>
              <!--                  /////////////////////////////-->
                  <!--                  ----------------------------------------->
                  <div class="row">
                    <div class="col">
                      <div class="form-group">
                        <label for="kcalStart">시작시 줄일 칼로리</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="kcalStart"
                            placeholder="kcalStart"
                            v-model="user.kcalStart"
                            v-validate="'required|max:200'"
                            name="kcalStart"
                        />
                        <div
                            v-if="errors.has('kcalStart') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("kcalStart") }}
                        </div>
                      </div>
                    </div>
                    <div class="col">
                      <div class="form-group">
                        <label for="kcalWeekly">매주 줄일 칼로리</label>
                        <input
                            type="number"
                            class="form-control form-control-user"
                            id="kcalWeekly"
                            placeholder="kcalWeekly"
                            v-model="user.kcalWeekly"
                            v-validate="'required|max:100'"
                            name="kcalWeekly"
                        />
                        <div
                            v-if="errors.has('kcalWeekly') && submitted"
                            class="alert-danger"
                        >
                          {{ errors.first("kcalWeekly") }}
                        </div>
                      </div>
                    </div>
                  </div>
              <!--                  /////////////////////////////-->
                  <div class="form-group">
                    <label for="fatGoal">목표 체지방</label>
                    <input
                        type="number"
                        class="form-control form-control-user"
                        id="fatGoal"
                        placeholder="fatGoal"
                        v-model="user.fatGoal"
                        v-validate="'required|max:50'"
                        name="fatGoal"
                    />
                    <div
                        v-if="errors.has('fatGoal') && submitted"
                        class="alert-danger"
                    >
                      {{ errors.first("fatGoal") }}
                    </div>
                  </div>
              <div class="form-group">
                성별
                <label for="female">여성</label>
                <input
                    type="radio"
                    name="female"
                    value="F"
                    v-model="user.gender"
                />
                <label for="male">남성</label>
                <input
                    type="radio"
                    name="male"
                    value="M"
                    v-model="user.gender"
                />
              </div>

              <div class="form-group">
                <button class="btn btn-primary btn-block">가입하기</button>
              </div>
              </form>
              <div class="text-center">
                <router-link to="/login" class="small"
                >이미 가입하셨나요? 로그인하러가기
                </router-link>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <div
      v-if="message"
      class="alert"
      :class="successful ? 'alert-success' : 'alert-danger'"
  >
    {{ message }}
  </div>

  </div>
</template>

<!--      화면에 에러메세지 출력 -->


<script>
import User from "@/models/user";
import SignDataService from "@/services/SignDataService";
/*eslint-disable*/
export default {
  name: "RegisterCom",
  data() {
    return {
      user: new User("", "", "", "", 0, 0,0,0,0,0,0,0), // 유저 객체
      submitted: false,
      successful: false,
      message: "", // 에러 메세지 저장용
    };
  },
  methods: {
    // 회원 가입 메소드
    handleRegister() {
      // console.log(this.user);
      this.message = "";
      this.submitted = true; // 회원가입 버튼클릭시
      //  유효성 체크 로직 실행( Vee-Validate 이용 )
      //  $validator.validate() 입력양식 유효성 체크가 통과하면
      //  isValid = true
      this.$validator.validate().then((isValid) => {
        // isValid = true 일때만 아래가 실행됨
        if (isValid) {
          console.log("-----------------handleRegister --------------")
          console.log(this.user);
          //  springboot 서버 통신 : 공유저장소의 비동기메소드 호출(register)
          this.$store
              .dispatch("auth/register", this.user)
              //  성공 / 실패 then
              //      성공하면 첫번째 매개변수 실행
              //      실패하면 두번째 매개변수 실행
              .then(
                  //  성공
                  (data) => {
                    // response == data ( 서버쪽 응답 메세지(객체) )
                    this.message = data.message;
                    this.successful = true;
                    //  강제 페이지 전환 : login
                    this.$router.push("/login");
                  },
                  // 실패
                  (error) => {
                    this.message = error.message || error.toString();
                    this.successful = false;
                  }
              );
        }
      });
    },
    // 모든 회원 조회 서비스 호출
    saveUser() {
      var data = {
        name: this.user.name,
        email: this.user.email,
        password: this.user.password,
        gender: this.user.gender,
        height: this.user.height,
        age: this.user.age,
        weight: this.user.weight,
        bodyFat:this.user.bodyFat,
        muscleMass:this.user.muscleMass,
        kclStart: this.user.kcalStart,
        kcalWeekly:this.user.kcalWeekly,
        fatGoal:this.user.fatGoal

      };
      // axios로 spring에 모든 회원 조회 요청
      SignDataService.addUser(data)
          // 성공하면 then으로 서버 데이터(response.data)가 들어옴
          .then((response) => {
            this.user.email = response.data.email;
            this.submitted = true; // 객체

            console.log(response.data);
          })
          // 실패하면 catch로 에러메세지가 들어옴
          .catch((e) => {
            alert(e);
          });
    },
    newUser() {
      this.submitted = false;
      this.user = {};
    },
  },
  computed: {
    loggedIn() {
      // 공유저장소의 user객체에 속성인 loggedIn 값을 가져옴
      return this.$store.state.auth.status.loggedIn;
    },
  },
  // 화면이 뜨자마자 실행되는 이벤트
  mounted() {
    //  로그인 되어 있는 유저이면 /profile로 강제 페이지 이동시킴
    if (this.loggedIn) {
      this.$router.push("/basic");
    }
  },
};
</script>

<style scoped>
</style>