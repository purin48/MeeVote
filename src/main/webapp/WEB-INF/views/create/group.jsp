<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>

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
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"
    />
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous"
      defer
    ></script>
    <!-- sweet alert -->
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11" defer></script>
    <!-- custom css -->
    <link rel="stylesheet" href="/css/create/group.css" />
    <!-- kakao mpa -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e5d6d2e61f5ab7c5909eee58f094989&libraries=services"></script>
    <!-- custom js import -->
    <script type="module" src="/js/create/group.js" defer></script>
    <!-- sidebar -->
    <link rel="stylesheet" href="/css/inc/sidebar.css" />
    <script type="module" type="module" src="/js/inc/sidebar.js" defer></script>
    <!-- alarm -->
    <link rel="stylesheet" href="/css/inc/alarm.css" />
    <script src="/js/inc/alarm.js" defer></script>
  </head>
  <body>
    <!-- 사이드바 include -->
    <jsp:include page="/WEB-INF/views/inc/sidebar.jsp">
      <jsp:param value="group" name="pageName" />
    </jsp:include>

    <!-- 알람 include -->
    <jsp:include page="/WEB-INF/views/inc/alarm.jsp"></jsp:include>
    
    <div class="top-container">
      <!-- 왼쪽 사이드 -->
      <div class="section" id="left-section">
        <p>그룹 일정 생성</p>
        <!-- 달력 -->
        <div class="calendar-container">
          <header class="calendar-header">
            <p class="calendar-current-date"></p>
            <div class="calendar-navigation">
              <span id="calendar-prev" class="material-symbols-rounded">
                <i class="bi bi-caret-left-fill"></i>
              </span>
              <span id="calendar-next" class="material-symbols-rounded">
                <i class="bi bi-caret-right-fill"></i>
              </span>
            </div>
          </header>
          <table class="calendar-body">
            <thead class="calendar-weekdays">
              <tr>
                <th>일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th>토</th>
              </tr>
            </thead>
            <tbody class="calendar-dates"></tbody>
          </table>
        </div>
        <!-- 달력 End -->
      </div>
      <!-- 왼쪽 사이드 End-->
      
      <!-- 맴버 추가 사이드 -->
      <div class="section" id="mid-section">
        <!-- 맴버 검색창 -->
        <div id="search-container">
          <div id="name-serach">
            <input type="text" placeholder="함께할 인원 검색">
            <i class="bi bi-search"></i>
          </div>
          <div id="search-list-container">
            <ul id="search-list"></ul>
          </div>
        </div>
        <!-- 추가된 맴버 -->
        <ul class="member-list">
        </ul>
      </div>
      <!-- 맴버 추가 사이드 End-->

      <!-- 오른쪽 사이드 -->
      <div class="section" id="right-section">
        <!-- 일정명 -->
        <div class="content-container" id="name-container">
          <div id="category-circle"></div>
          <input type="text" class="form-control" placeholder="일정 이름 입력" />
        </div>
        <!-- 날짜 입력 -->
        <div class="row-container">
          <div class="dateinput-container">
            <div class="date-text">
              <i class="bi bi-clock"></i>
              <span>시작일</span>
            </div>
            <input
              type="date"
              class="date-input form-control"
              id="start-date"
            />
            <input
              type="time"
              class="time-input form-control"
              id="start-time"
            />
          </div>
          <div class="dateinput-container">
            <div class="date-text">
              <i class="bi bi-clock-fill"></i>
              <span>종료일</span>
            </div>
            <input type="date" class="date-input form-control" id="end-date" />
            <input type="time" class="time-input form-control" id="end-time" />
          </div>
        </div>
        <!-- 날짜 입력End -->
        <!-- 중앙 입력칸 -->
        <div class="row-container" id="mid-container">
          <!-- 마감일 입력 End -->
          <div class="dateinput-container">
            <div class="date-text">
              <i class="bi bi-clock"></i>
              <span>투표마감일</span>
            </div>
            <input
              type="date"
              class="date-input form-control"
              id="vote-date"
            />
            <input
              type="time"
              class="time-input form-control"
              id="vote-time"
            />
          </div>
          <!-- 마감일 입력 End -->
          <!-- 중앙 오른쪽 입력칸 -->
          <div class="column-container">
            <!-- 하루종일 체크 -->
            <div class="content-container" id="checkbox-container">
              <span>하루종일</span>
              <input
                class="form-check-input"
                type="checkbox"
                value=""
                id="allday-check"
              />
            </div>
            <!-- 하루종일 체크 End-->
            <!-- 카테고리 -->
            <div class="content-container" id="category-container">
              <i class="bi bi-pin-angle"></i>
              <select id="category-select"></select>
            </div>
            <!-- 카테고리 End-->
          </div>
          <!-- 중앙 오른쪽 입력칸 End-->
        </div>
        <!-- 중앙 입력칸 End-->
        <!-- 마감일 -->

        <!-- 장소 End-->
        <!-- 상세 설명 -->
        <div class="content-container" id="description-container">
          <i class="bi bi-text-paragraph"></i>
          <textarea
            name=""
            id=""
            placeholder="상세설명을 입력하세요"
            rows="5"
          ></textarea>
        </div>
        <!-- 상세 설명 End-->
        <p class="input-warning">마감일은 현재 시각 이후여야합니다.</p>
        <button id="save-btn">저장</button>
      </div>
      <!-- 오른쪽 사이드 End-->

    </div>
  </body>
</html>