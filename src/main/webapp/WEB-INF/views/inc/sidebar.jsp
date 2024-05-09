<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 사이드바 상단 토글 -->
<div id="nav-create-btn">
  <i class="bi bi-list"></i>
</div>

<!-- 사이드바 -->
<nav class="side-nav">
  <!-- 로고 -->
  <div class="nav-head">
    <img src="image/logo/logo_white2.png" alt="" id="logo-img"/>
    <i class="bi bi-arrow-left-circle" id="nav-delete-btn"></i>
  </div>
  <!-- 로고 End -->
  <!-- 메뉴 -->
  <div class="nav-content">
    <!-- 캘린더 -->
    <div class="menu-item ${param.pageName == 'calendar' ? 'selected' : ''}">
      <div class="menu-icon">
        <i class="bi bi-calendar-week"></i>
      </div>
      <p>캘린더</p>
    </div>
    <!-- 테이블 -->
    <div class="menu-item ${param.pageName == 'table' ? 'selected' : ''}">
      <div class="menu-icon">
        <i class="bi bi-file-earmark-spreadsheet"></i>
      </div>
      <p>일정 테이블</p>
    </div>
    <!-- 개인 일정 -->
    <div class="menu-item ${param.pageName == 'personal' ? 'selected' : ''}">
      <div class="menu-icon">
        <i class="bi bi-person-fill"></i>
      </div>
      <p>개인 일정 생성</p>
    </div>
    <!-- 그룹 일정 -->
    <div class="menu-item ${param.pageName == 'group' ? 'selected' : ''}">
      <div class="menu-icon">
        <i class="bi bi-people-fill"></i>
      </div>
      <p>그룹 일정 생성</p>
    </div>
  </div>
  <!-- 메뉴 End -->
  <!-- 프로필 -->
  <div class="nav-foot">
    <div class="nav-foot-top">
      <div class="profile-img-container">
        <img alt="" id="profile-img" />
      </div>
      <div class="name-icon-container">
        <span id="info-name"></span>
        <i class="bi bi-box-arrow-in-left" id="logout-btn"></i>
      </div>
    </div>
    <p id="info-email"></p>
  </div>

  <!-- 프로필 End -->
</nav>
