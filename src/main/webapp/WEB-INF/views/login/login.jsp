<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
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
	<link rel="stylesheet" href="/css/login.css">
	<!-- js import -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" defer></script>
	<script src="/js/login.js" defer></script>
</head>

<body>
	<div class="left-banner">
		<img src="/image/logo/logo_white.png" alt="MeeVote-logo" class="left-logo">
	</div>
	<div class="right-section">
		<img src="/image/logo/logo_mint.png" alt="MeeVote-logo" class="right-logo">
		<form class="form-container">
			<!-- 이메일 -->
			<div class="input-group" id="email-container">
				<span class="input-group-text"><i class="bi bi-envelope"></i></span>
				<input type="email" class="form-control" id="email-input" placeholder="이메일">
			</div>
			<!-- 비밀번호 -->
			<div class="input-group" id="password-container">
				<span class="input-group-text"><i class="bi bi-shield-lock"></i></span>
				<input type="password" class="form-control" id="password-input" placeholder="비밀번호">
			</div>
		</form>
		<div class="complete-container">
			<p>이메일 또는 비밀번호를 잘못 입력하였습니다.</p>
			<button type="button">로그인</button>
			<a href="${requestScope.requestURL}/register">등록된 계정이 없으십니까?</a>
		</div>
  </button>

	</div>
</body>
</html>