<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>MeeVote</title>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
	<link rel="stylesheet" href="css/login.css">
</head>

<body>
	<div class="left-banner">
		<img src="image/sidebar/logo_white.png" alt="MeeVote-logo" class="left-logo">
	</div>
	<div class="right-section">
		<img src="image/sidebar/logo_mint.png" alt="MeeVote-logo" class="right-logo">
		<form class="form-container">
			<!-- 이메일 -->
			<div class="input-group" id="email-container">
				<span class="input-group-text" id="eamil-input"><i class="bi bi-envelope"></i></span>
				<input type="email" class="form-control" id="eamil-input" placeholder="이메일">
				<button class="input-btn" type="button">중복확인</button>
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 이메일 체크 -->
			<div class="input-group" id="email-code-container">
				<span class="input-group-text" id="eamil-code-input"><i class="bi bi-envelope-open-fill"></i></span>
				<input type="email" class="form-control" id="eamil-code-input" placeholder="이메일 확인 코드">
				<button class="input-btn" type="button">전송</button>
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 비밀번호-->
			<div class="input-group" id="password-container">
				<span class="input-group-text" id="password-input"><i class="bi bi-shield-lock"></i></span>
				<input type="password" class="form-control" id="password-input" placeholder="비밀번호">
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 비밀번호 체크 -->
			<div class="input-group" id="password-check-container">
				<span class="input-group-text" id="password-check-input"><i class="bi bi-shield-lock-fill"></i></span>
				<input type="password" class="form-control" id="password-check-input" placeholder="비밀번호 확인">
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 이름 -->
			<div class="input-group" id="name-container">
				<span class="input-group-text" id="name-input"><i class="bi bi-person"></i></span>
				<input type="text" class="form-control" id="name-input" placeholder="이름">
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 전화번호 -->
			<div class="input-group" id="phone-number-container">
				<span class="input-group-text" id="phone-number-input"><i class="bi bi-telephone"></i></span>
				<input type="text" class="form-control" id="phone-number-input" placeholder="전화 번호">
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 주소 -->
		</form>
		<div class="compelte-container">
			<button type="button" class="complete-button">회원가입</button>
			<a href="${requestScope.requestURL}/login" class="move-anchor">이미 가입한 계정이 있으십니까?</a>
		</div>
		</button>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	</div>
</body>
</html>