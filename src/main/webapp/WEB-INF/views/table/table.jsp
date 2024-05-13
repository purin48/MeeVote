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
      <jsp:param value="table" name="pageName"/>
    </jsp:include>

    <div class="top-container">
      <!-- 상단부 -->
      <div class="head-container">

      </div>
      <!-- 상단부 End -->
      <!-- 테이블 -->
      <div class="main-container">

      </div>
      <!-- 테이블 End -->
    </div>
  </body>
</html>
