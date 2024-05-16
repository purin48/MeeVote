<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>MeeVote</title>
    <!-- font -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap"
      rel="stylesheet"
    />
    <!-- jquery -->
    <link
      rel="stylesheet"
      href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/themes/smoothness/jquery-ui.css"
    />
    <script
      src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"
      defer
    ></script>
    <script
      src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.13.2/jquery-ui.min.js"
      defer
    ></script>
    <!-- bootstrap -->
    <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
    crossorigin="anonymous"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
      defer
    ></script>
    <!-- sweet alert -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11" defer></script>
    <!-- chartjs -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.2/dist/chart.umd.min.js"></script>
    <!-- kakao mpa -->
    <script
      type="text/javascript"
      src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e5d6d2e61f5ab7c5909eee58f094989&libraries=services"
    ></script>
    <!-- alarm -->
    <link rel="stylesheet" href="/css/inc/alarm.css" />
    <script src="/js/inc/alarm.js" defer></script>
    <!-- custom css -->
    <link rel="stylesheet" href="/css/inc/sidebar.css" />
    <link rel="stylesheet" href="/css/table/table.css" />
    <!-- custom js import -->
    <script type="module" src="/js/inc/sidebar.js" defer></script>
    <script type="module" src="/js/table/table.js" defer></script>
  </head>
  <body>
    <!-- 사이드바 include -->
    <jsp:include page="/WEB-INF/views/inc/sidebar.jsp">
      <jsp:param value="table" name="pageName" />
    </jsp:include>

    <!-- 알람 include -->
    <jsp:include page="/WEB-INF/views/inc/alarm.jsp"></jsp:include>

    <div class="top-container">
      <!-- 상단부 -->
      <div class="head-container">
        <div class="important-container">
          <div class="chart" id="circle-chart">
            <canvas></canvas>
          </div>
          <div class="chart" id="bar-chart">
            <canvas></canvas>
          </div>
        </div>
        <div class="important-container">
          <!-- 투표 중인 일정 -->
          <div class="root-container">
            <p>투표 중인 일정</p>
            <div class="carousel-container voting-container">
              <i class="bi bi-arrow-left-circle-fill carousel_prev"></i>
              <div class="carousel_main">
                <div class="carousel_wrapper">
                </div>
              </div>
              <i class="bi bi-arrow-right-circle-fill carousel_next"></i>
            </div>
          </div>
          <!-- 투표 중인 일정 End-->
          <!-- 예정된 일정 -->
          <div class="root-container">
            <p>예정된 일정</p>
            <div class="carousel-container future-container">
              <i class="bi bi-arrow-left-circle-fill carousel_prev"></i>
              <div class="carousel_main">
                <div class="carousel_wrapper"></div>
              </div>
              <i class="bi bi-arrow-right-circle-fill carousel_next"></i>
            </div>
            <!-- 예정된 일정 End -->
          </div>


        </div>

      </div>
      <!-- 상단부 End -->

      <!-- 하단부 -->
      <div class="foot-container">
        <!-- 필터링 -->
        <div class="filter-container">
          <!-- 카테고리 필터링 -->
          <div class="category-container">
            <i class="bi bi-pin-angle"></i>
            <select class="category-select">
              <option value="0">전체</option>
            </select>
          </div>
          <!-- 키워드 검색 -->
          <div class="name-serach">
            <input type="text" placeholder="미입력시 전체 검색">
            <i class="bi bi-search"></i>
          </div>
        </div>
        <!-- 필터링 End -->
        <!-- 테이블 -->
        <div class="data-container">
          <table class="table table-hover">
            <thead>
              <tr>
                <th scope="col is-group">단체여부</th>
                <th scope="col category">카테고리</th>
                <th scope="col start-date">시작날짜</th>
                <th scope="col name">일정명</th>
                <th scope="col place">장소</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
        </div>
        <i class="bi bi-chevron-double-down down-btn"></i>
        <!-- 테이블 End -->
      </div>
    </div>
  </body>
</html>
