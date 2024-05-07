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
			<div class="form-floating">
				<input type="email" class="form-control" id="floating-email">
				<label for="floating-email">이메일</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="floating-name">
				<label for="floating-name">이름</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floating-password">
				<label for=" floating-password">비밀번호</label>
			</div>
			<div class="form-floating">
				<input type="password" class="form-control" id="floating-password-confirm">
				<label for="floating-password-confirm">비밀번호 확인</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="floating-address">
				<label for="floating-addressm">주소</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="floating-phone-number">
				<label for=" floating-phone-number">전화번호</label>
			</div>
			<div class="form-floating">
				<input type="text" class="form-control" id="floating-email-code">
				<label for=" floating-email-code">이메일 확인 코드</label>
			</div>
		</form>
		<div class="compelte-container">
			<button type="button" class="complete-button">회원가입</button>
			<a href="${requestScope.requestURL}/login" class="move-anchor">이미 가입한 계정이 있으십니까?</a>
		</div>
		</button>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>