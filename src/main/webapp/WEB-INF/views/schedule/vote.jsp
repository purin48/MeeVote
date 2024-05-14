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
    <!-- kakao mpa -->
    <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e5d6d2e61f5ab7c5909eee58f094989&libraries=services"></script>
    <!-- sidebar -->
    <link rel="stylesheet" href="/css/inc/sidebar.css" />
    <script type="module" src="/js/inc/sidebar.js" defer></script>
    <!-- alarm -->
    <link rel="stylesheet" href="/css/inc/alarm.css" />
    <script src="/js/inc/alarm.js" defer></script>
    <!-- custom css -->
    <link rel="stylesheet" href="/css/schedule/vote.css" />
    <!-- custom js import -->
    <script type="module" src="/js/schedule/vote.js" defer></script>
  </head>
  <body>
    <!-- 사이드바 include -->
    <jsp:include page="/WEB-INF/views/inc/sidebar.jsp" />

    <!-- 알람 include -->
    <jsp:include page="/WEB-INF/views/inc/alarm.jsp">
      <jsp:param value="calendar" name="scheduleName" />
    </jsp:include>

    <!-- 검색창 -->
    <div class="search-container">
      <div class="info-container">
        <div class="text-container">
          <p class="name">테스트 일정입니다.</p>
          <p class="deadline">2024-05-17까지</p>
        </div>
        <div class="end-btn">
          <i class="bi bi-alarm"></i>
        </div>
      </div>
      <!-- 검색창 -->
      <div class="place-search">
        <input type="text" placeholder="추가할 장소 검색">
        <i class="bi bi-search"></i>
      </div>
      <!-- 검색 항목 리스트 -->
      <div class="search-list-container">
        <ul class="search-list"></ul>
      </div>
    </div>
    <!-- 검색창 End-->

    <!-- 투표항목 리스트 -->
    <div class="vote-list-container">
      <ul class="vote-list">
      </ul>
    </div>
    <div class="member-container">
      <div class="del-btn"><i class="bi bi-door-open"></i></div>
      <div class="section" id="mid-section">
        <div id="search-container">
          <div id="name-serach">
            <input type="text" placeholder="맴버 검색">
            <i class="bi bi-search"></i>
          </div>
          <div id="search-list-container">
            <ul id="search-list">
            </ul>
          </div>
        </div>
        <ul class="member-list">
        </ul>
      </div>
    </div>

    <button class="member-btn">맴버 관리</button>

    <!-- 맵 컨테이너 -->
    <div class="map-container"></div>
    <!-- 맵 컨테이너 End -->
  </body>
</html>
