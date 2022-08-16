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
          <div class="sidebar-brand-icon ">
            <i class="fas fa-laptop-medical"></i>
          </div>
          <div class="sidebar-brand-text mx-3">Nutrition Assistant</div>
        </router-link>

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
      <div class="container-fluid" id="page-top">
        <!-- Page Heading -->
        <!-- TODO : 내용 수정 -->
        <!-- Content Row -->
        <div class="row">
          <!-- Content Column -->
          <div class="col-lg-12 mb-4">
            <!-- Project Card Example -->
            <div class="mt-3 card shadow mb-4">
              <div class="card-header py-3">
                <!-- TODO : Project -> 활동대사량 이름 수정 -->
                <h6 class=" m-0 font-weight-bold text-primary">
                  보충제 추천
                </h6>
                <ul class="mt-3 nav nav-tabs">
                  <li class="nav-item">
                    <a class="nav-link active" data-toggle="tab" href="#qwe">초보자</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#asd">숙련자</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link" data-toggle="tab" href="#zxc">기타건강</a>
                  </li>
                </ul>
                <div class="col-md-12 tab-content">
                  <div class=" row tab-pane fade show active" id="qwe">
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">단백질</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 체중 1kg당 1.6~2g
                        <br><br>
                        <strong>코멘트</strong> : 초보자는 2g이 좋다, 흰우유(500ml)를 잘 못먹으면 WPI, 잘 먹으면 WPC, 적당히 잘 먹으면 WPI+WPC
                        <br><br>
                        <strong>대상</strong> : 단백질을 잘 못챙겨먹는 사람,
                        <br><br>
                        섭취방법 : 운동후 섭취 혹은 단백질이 적은 식사 후, 운동후 식사가 바로 있다면 20g, 운동후 식사가 바로 없다면 40g 타서 3/4을 바로 먹고 1/4은 30분후 섭취.
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">탄수화물</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> :                       <br><br>
                        <strong>코멘트</strong> : 식사를 통한 섭취를 더 추천합니다.

                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">종합비타민</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 1/2 ~ 1서빙
                        <br><br>
                        <strong>코멘트</strong> : 식사 부실 시 1서빙, 보통 1/2 서빙. 마이프로틴 알파맨은 추천 제품은 아닙니다. 비타민류는 아이허브, 쿠팡에서 구매하세요
                      </div>
                    </div>

                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">유산균(프로바이오틱스)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 100억(10 Billion)
                        <br><br>
                        <strong>코멘트</strong> : 소화 능력이 약한 사람에게 추천
                        <br><br>
                        <strong>대상</strong> : 단백질을 잘 못챙겨먹는 사람,
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">섬유질</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 25g
                        <br><br>
                        <strong>코멘트</strong> : 소화 능력이 약한 사람에게 추천, 익힌 채소 추천, 섭취량 한번에 늘리지 말것
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">글루타민</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 5g
                        <br><br>
                        <strong>코멘트</strong> : 소화 능력이 약한 사람에게 추천
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">단백질</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 체중 1kg당 1.6~2g
                        <br><br>
                        <strong>코멘트</strong> : 초보자는 2g이 좋다, 흰우유(500ml)를 잘 못먹으면 WPI, 잘 먹으면 WPC, 적당히 잘 먹으면 WPI+WPC
                        <br><br>
                        <strong>대상</strong> : 단백질을 잘 못챙겨먹는 사람,
                        <br><br>
                        섭취방법 : 운동후 섭취 혹은 단백질이 적은 식사 후, 운동후 식사가 바로 있다면 20g, 운동후 식사가 바로 없다면 40g 타서 3/4을 바로 먹고 1/4은 30분후 섭취.
                      </div>
                    </div>

                  </div>
                  <div class=" row tab-pane fade show active" id="asd">
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">카페인(집중력, 유산소 능력 증가)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 체중 1kg당 3~6mg, 평균 200mg~250mg
                        <br><br>
                        <strong>코멘트</strong> : 사람마다 개인차 심함, 부스터의 카페인과 커피, 에너지 드링크의 카페인이 다름, 부스터가 더 빠르고 강함, 효과가 강하고 좋으나 불면, 피로, 혈압상승, 속쓰림 등 유발될 수 있음
                        <br><br>
                        <strong>대상</strong> : 지구력(5~105분), 근력운동(짧은시간)

                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">크레아틴(웨이트 능력 증가)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 꾸준히 섭취 - 5g, 빠르게 로딩 - 20g 7일 동안
                        <br><br>
                        <strong>코멘트</strong> : 지속적 섭취를 통해 체내 보유량 증가 목표, 근육량이 좀 있어야 효과
                        <br><br>
                        <strong>대상</strong> : 150초 이하 운동, 30초 이하 운동이 가장 효과적

                      </div>
                    </div>

                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">베타알라닌(웨이트 능력 증가)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 65mg/kg, 따끔거림이 싫다면, 1g씩 나눠서 섭취
                        <br><br>
                        <strong>코멘트</strong> : 지속적 섭취를 통해 체내 보유량 증가 목표
                        <br><br>
                        <strong>대상</strong> : 젖산이 생성되는 운동(30초~10분) 매우 짧은 운동
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Nitrate(중강도 운동능력 증가)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 310~560mg, 무, 비트 300g
                        <br><br>
                        <strong>코멘트</strong> : 섭취가 까다로움, 보충제도 존재하나, 식품 섭취 권장
                        <br><br>
                        <strong>대상</strong> : 12분 미만은 애매, 12분 이상 40분 이하 효과
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">Sodium Bicarbonate(웨이트 능력 증가)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 0.2~0.4g/kg
                        <br><br>
                        <strong>코멘트</strong> : 마트에 500원으로 살 수 있는 성분, A급 성분으로 유명하지만, 왜 보충제로 안나오는지 먹어보면 알 수 있다. 속쓰림 주의, 노익스에 가스 소리 원인
                        <br><br>
                        <strong>대상</strong> : 60초 ~ 10분, 길어질수록 효과 반감

                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">스포츠 드링크(에너지, 수분공급)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 게토레이, 포카리스웨트, 30분당 500ml(초과섭취x)
                        <br><br>
                        <strong>코멘트</strong> : 수분과 탄수화물(에너지)의 빠른 공급, 운동중에 공급이 가능하다는 장점, 운동 강도, 소화 능력에 따라 섭취량과 농도 조절 필수
                        <br><br>
                        <strong>대상</strong> : 운동시간이 매우 긴 경우, 장시간 공복 후 운동할 경우 추천
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">BCAA
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 10~15g
                        <br><br>
                        <strong>코멘트</strong> : 유청단백질의 20%는 BCAA, 섭취량만큼 BCAA섭취 줄일 것, BCAA 단맛은 100% 첨가물, 첨가물 다량섭취 주의
                        <br><br>
                        <strong>대상</strong> : 운동 시 맹물 싫은 사람
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">시트룰린, 아르기닌(펌핑, 혈관확장)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 시트룰린 6~8g, 아르기닌 3~9g
                        <br><br>
                        <strong>코멘트</strong> : 아르기닌이 NO산화질소, 펌핑 혈관확장, Erection에 도움이 됨. 하지만 공복에 섭취해야 하고 한번에 먹을 경우 부담이 될 수 있음. 혈중 감소가 빠름, 시트룰린은 이 부분이 보완됨. 혈중 농도 유지가 좋고 섭취가 용이함.
                        <br><br>
                        <strong>대상</strong> : 운동수행 능력 도움에는 호불호가 갈림. 실제로 펌핑에는 도움이 되는지도 여러가지 의견이 갈림. 혈관확장을 원한다면 섭취
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">HMB(근육 회복, 근육 증가)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 3g
                        <br><br>
                        <strong>코멘트</strong> : 근육 회복, 근육 성장, 굉장히 높은 수준의 신체 데미지(변화), 가 있는 군에서 추천됨.
                        <br><br>
                        <strong>대상</strong> : 고강도 웨이트 운동하는 사람. 운동 완전 처음 시작하는 사람
                      </div>
                    </div>

                  </div>
                  <div class=" row tab-pane fade show active" id="zxc">
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">비타민D
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 2000~5000IU
                        <br><br>
                        <strong>코멘트</strong> : 햇빛을 본볼 경우 섭취량 200~4000IU, 5000IU 이상 섭취 시 중간에 혈중 비타민 D 검사할 것
                        <br><br>
                        <strong>대상</strong> : 햇빛 안보는 사람 추천, K2는 칼슘침착 우려시 섭취
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">칼슘</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 700~1000mg
                        <br><br>
                        <strong>코멘트</strong> : 칼슘강화우유, 카제인, 밀크프로틴 안먹으면 추천, 많이 섭취 시 마그네슘 아연 흡수 저해 가능,(e.g. 밀크프로틴+ZMA안됨) 칼슘 침착이 걱정되면 Vit K 섭취
                        <br><br>
                        <strong>대상</strong> : 체중이 많이 나갈경우 칼슘 섭취량 늘릴 것, 체중당 11.2mg/kg

                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">오메가3
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 250mg - 필수지방산 섭취, 2~4g - 심혈관계 예방, 약간의 근육회복증가와 데미지 감소
                        <br><br>
                        <strong>코멘트</strong> : EPA+DHA 합친 양, 단순, 필수지방선 섭취가 목적이라면 크릴오일, 식물성 오메가3 섭취도 가능, 일반적으로 알려진 오메가3 효과를 보려면 고르지 말것.
                        <br><br>
                        <strong>대상</strong> : 일반적으로 섭취하면 좋음, 특히 중성지방 수치가 높은 사람 추천
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">아연</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 10~50mg
                        <br><br>
                        <strong>코멘트</strong> : 칼슘, 아연, 마그네슘은 서로 경쟁 흡수함, 섭취량이 많을 경우 나눠서 섭취, 섭취시 속 불편할 가능성, 그 경우 식후에 섭취
                        <br><br>
                        <strong>대상</strong> : 땀 많이 흘리고 편식이 심한 경우, 아연은 2차 성장기때 필수
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">마그네슘</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 300mg
                        <br><br>
                        <strong>코멘트</strong> : 칼슘, 아연, 마그네슘은 서로 경쟁흡수함, 섭취량이 많을 경우 나눠서 섭취, 섭취시 속 불편할 가능성, 그 경우 식후에 섭취
                        <br><br>
                        <strong>대상</strong> : 땀 많이 흘리고 편식이 심한 경우
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">밀크씨슬(간 회복)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 장기 섭취시 200mg 이하로, 단기 섭취시 200~400mg
                        <br><br>
                        <strong>코멘트</strong> :
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">홍경천(피로회복)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 500mg, 운동전(부스터와 함께) 혹은 공복에 섭취
                        <br><br>
                        <strong>코멘트</strong> : 육체 피로에 도움이 될 수 있음. 단, 피로회복은 수면과 영양섭취가 가장 1순위, 보충제는 약간의 도움임.
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">테아닌(피로회복)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 200mg, 취침 30분전 섭취, 부스터와 함께 섭취 가능
                        <br><br>
                        <strong>코멘트</strong> : 정신적 스트레스, 높은 흥분,긴장을 완화시켜주는 제품이다. 특이하게도 정신적 스트레스에도 도움이 되지만, 부스터(카페인)과 같이도 사용된다. 부스터의 과도한 흥분을 억제함으로써 집중력을 올리는 조합으로 사용된다. 진정효과가 있지만 수면유도가 아니기 때문에 부담없이 사용가능하다. 단, 작용이 사람마다 편차가 있으며 작용강도가 높지 않다는점 유의해야한다.
                        <br><br>
                        <strong>대상</strong> : 정신적 스트레스를 많이 받는경우, 카페인에 심하게 민감한 경우
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">보스웰리아(관절)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 500mg, 하루 1~3회 (통증이 심하면 섭취량 늘릴것)
                        <br><br>
                        <strong>코멘트</strong> : 관절 제품은 어디까지나 염증을 살짝 줄여주는 용도입니다. 운동시 관절에 염증이 생기지 않도록 관리를 잘 해주시기 바랍니다.
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">커큐민(항산화, 관절)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 500mg
                        <br><br>
                        <strong>코멘트</strong> : 항산화 및 관절염증에 도움이 될 수 있음.
                        <br><br>
                        <strong>대상</strong> : 단백질을 잘 못챙겨먹는 사람,
                        <br><br>
                        섭취방법 : 식후 섭취
                      </div>
                    </div>


                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">유산균(프로바이오틱스)
                        </h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 100억(10 Billion)
                        <br><br>
                        <strong>코멘트</strong> : 소화 능력이 약한 사람에게 추천
                        <br><br>
                        <strong>대상</strong> : 단백질을 잘 못챙겨먹는 사람,
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">섬유질</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 25g
                        <br><br>
                        <strong>코멘트</strong> : 소화 능력이 약한 사람에게 추천, 익힌 채소 추천, 섭취량 한번에 늘리지 말것
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">글루타민</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 5g
                        <br><br>
                        <strong>코멘트</strong> : 소화 능력이 약한 사람에게 추천
                      </div>
                    </div>
                    <div class="col-md-12 col-12 card shadow mb-4">
                      <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">단백질</h6>
                      </div>
                      <div class="card-body">
                        <strong>섭취량</strong> : 체중 1kg당 1.6~2g
                        <br><br>
                        <strong>코멘트</strong> : 초보자는 2g이 좋다, 흰우유(500ml)를 잘 못먹으면 WPI, 잘 먹으면 WPC, 적당히 잘 먹으면 WPI+WPC
                        <br><br>
                        <strong>대상</strong> : 단백질을 잘 못챙겨먹는 사람,
                        <br><br>
                        섭취방법 : 운동후 섭취 혹은 단백질이 적은 식사 후, 운동후 식사가 바로 있다면 20g, 운동후 식사가 바로 없다면 40g 타서 3/4을 바로 먹고 1/4은 30분후 섭취.
                      </div>
                    </div>

                  </div>
                </div>

              </div>
            </div>
          </div>
        </div>
      </div>


    </div>


    <!--          아침 점심 저녁 간식 테이블 끝-->
  </div>
</template>

<script>
/*eslint-disable*/
export default {
  name: "supplement",

  methods:{
    logOut() {
      // dispatch 호출하는 메소드 : actions에 있는 메소드를 호출함
      this.$store.dispatch("auth/logout");
      // 로그아웃 후 이동할 페이지 지정
      this.$router.push("/");
    },
  }
};

</script>

<style scoped>
</style>