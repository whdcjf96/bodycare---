<template>
  <div class="container">
    <!-- Outer Row -->
    <div class="row justify-content-center">
      <div class="col-xl-10 col-lg-12 col-md-9">
        <div class="card o-hidden border-0 shadow-lg my-5">
          <div class="card-body p-0">
            <!-- Nested Row within Card Body -->
            <div class="row">
              <div class="col-lg-6 d-none d-lg-block bg-login-image"></div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">환영합니다!</h1>
                  </div>
                  <form class="user" @submit.prevent="handleLogin">
                    <div class="form-group">
                      <label for="email">Email</label>
                      <input
                        type="email"
                        class="form-control form-control-user"
                        id="exampleInputEmail"
                        aria-describedby="emailHelp"
                        placeholder="Enter Email Address..."
                        name="email"
                        v-model="user.email"
                        v-validate="'required'"
                      />
                      <div
                        v-if="errors.has('username')"
                        class="alert alert-danger"
                        role="alert"
                      >
                        Username is required!(필수)
                      </div>
                    </div>
                    <div class="form-group">
                      <label for="password">Password</label>
                      <input
                        type="password"
                        class="form-control form-control-user"
                        id="exampleInputPassword"
                        placeholder="Password"
                        name="password"
                        v-model="user.password"
                        v-validate="'required'"
                      />
                      <div
                        v-if="errors.has('password')"
                        class="alert alert-danger"
                        role="alert"
                      >
                        Password is required!(필수)
                      </div>
                    </div>

                    <div class="form-group">
                      <button
                        class="btn btn-primary btn-block"
                        :disabled="loading"
                        @click="loggedIn"
                      >
                        <span
                          v-show="loading"
                          class="spinner-border spinner-border-sm"
                        ></span>
                        <span>로그인</span>
                      </button>
                    </div>
                    <div class="form-group">
                      <div
                        v-if="message"
                        class="alert alert-danger"
                        role="alert"
                      >
                        {{ message }}
                      </div>
                    </div>
                    <router-link
                      to="/register"
                      class="btn btn-danger btn-user btn-block"
                    >
                      회원가입
                    </router-link>
                  </form>
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
import User2 from "@/models/user2";
/* eslint-disable */
export default {
  name: "LogInCom",
  data() {
    return {
      user: new User2("",""),
      loading: false,
      message: "",
    };
  },
  computed: {
    // 값 : false, true
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },  
  // 화면이 뜨자마자 실행되는 이벤트
  // created(Vue 객체가 최초로 만들어 질때 실행됨)
  // mounted(화면 모두 뜰때 실행됨)
  created() {
    // 로그인이 되었으면 loggedIn = true
    // 로그인이 안되었으면 loggedIn = false
    // 로그인이 되었으면 사용자를 프로필 페이지로 안내
    if (this.loggedIn) {
      // profile 페이지로 강제 이동함
      this.$router.push("/basic");
    }
  },
  methods: {
    //  로그인 메소드 정의
    handleLogin() {
      this.loading = true;
      //  Vee-Validation npm 설치 : 뷰에서 유효성 체크 모듈
      //  validateAll => v-validate 체크해서 모두 true, false 인지 확인
      //  값이 isValid = true ( false )
      this.$validator.validateAll().then((isValid) => {
        //  유효성 체크가 걸린 입력박스가 하나라도 에러가 나면 : false
        //  isValid = false 이면 로그인 함수 종료
        if (!isValid) {
          this.loading = false;
          return;
        }


        //  로그인 절차 진행
        //  springboot 서버와 통신
        if (this.user.email && this.user.password) {
          //  springboot로 username, password 전송해서 로그인 진행
          //  공유저장소의 비동기 메소드 호출 ( login )
          this.$store
            .dispatch("auth/login", this.user)
            //  결과가 성공하면 then(첫번째매개변수)
            //  실패하면 then(두번째매개변수)
            .then(
              // 성공
              () => {
                // 로그인 성공시 자동 페이지 전환 : /profile 페이지
                alert(this.$store.state.auth.user.name + " 님 반갑습니다!");
                this.$router.push("/basic");
              },
              // 실패
              (error) => {
                // alert(error);
                this.loading = false;
                this.message = error.message || error.toString();
              }
            );
        }
      });
    },
  },
};
</script>

<style scoped>
</style>