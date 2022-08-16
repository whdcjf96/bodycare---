<template>
  <div id="content-wrapper" class="d-flex flex-column">
    <HeaderCom></HeaderCom>
    <div id="wrapper" style="width: 100%" >

      <!-- Begin Page Content -->
      <div style="width: 100%; background-color: #FFFFFF">
        <div class="container-fluid" id="page-top">
          <div class="row row--dense mt-3">
            <div  class="col-md-8 col-12 center mr-0 ml-0 ">
              <img class="mt-4 img-responsive center-block" src="../assets/main2.png" height=400 width="100%" >
            </div>
            <div  class="col-md-4 col-12 center mr-0 ml-0">
              <img class="img-responsive center-block" src="../assets/main6.png" height=400 width="100%" style="opacity: 0.8">
            </div>
          </div>
          <!-- row -->
          <div class="row mt-3">
            <!-- 1번-->
            <div class="col">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary text-center">
                    운동도우미
                  </h6>
                </div>
                <div class="card-body">체중, 체지방률, 활동 정보, 식단 등을 입력하여, 충족해야 할 소비 칼로리 및 식단을 관리할 수 있도록 도와줍니다.</div>
              </div>
            </div>
            <!-- -->
            <!--2번-->
            <div class="col">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary text-center">
                    체중변화 관리
                  </h6>
                </div>
                <div class="card-body">매일 기록한 체중과 칼로리 변동량을 통해 예측한 체중 그래프를 통해, 현재 체중 증, 감량의 상황을 파악할 수 있습니다.</div>
              </div>
            </div>
            <!--2번끝-->
            <!--3번-->
            <div class="col">
              <div class="card shadow mb-4">
                <div class="card-header py-3">
                  <h6 class="m-0 font-weight-bold text-primary text-center">
                    보충제 추천
                  </h6>
                </div>
                <div class="card-body">보충제의 종류,섭취양,섭취 방법 및 상황에 맞게 선택할 수 있도록 도와줍니다.</div>
              </div>
            </div>
            <!--3번끝-->
          </div>
          <!--row끝-->
        </div>
      </div>
    </div>
    <FooterCom></FooterCom>
  </div>
</template>

<script>

import HeaderCom from '@/components/HeaderCom.vue'
import FooterCom from '@/components/FooterCom.vue'

export default {
  name: "HomeView",
  components: {
    HeaderCom,
    FooterCom
  }

}
</script>

<style>

</style>