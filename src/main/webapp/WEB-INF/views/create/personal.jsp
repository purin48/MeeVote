<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MeeVote</title>
      <!-- css import -->
      <link rel="preconnect" href="https://fonts.googleapis.com">
      <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
      <link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
      <link rel="stylesheet" href="css/inc/sidebar.css"/>
      <link rel="stylesheet" href="css/create/common.css"/>
      <!-- js import -->
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
      crossorigin="anonymous" defer></script>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" defer></script>
      <script src="js/inc/sidebar.js" defer></script>
      <script src="js/create/common.js" defer></script>
</head>
<body>
  <!-- 사이드바 include -->
  <jsp:include page="/WEB-INF/views/inc/sidebar.jsp">
    <jsp:param value="personal" name="pageName"/>
  </jsp:include>
  <div class="top-container">
    <div>
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
                <th>일</th>
                <th>월</th>
                <th>화</th>
                <th>수</th>
                <th>목</th>
                <th>금</th>
                <th>토</th>
            </thead>
        </table>
      </div>
    </div>
  </div>
</body>
</html>