<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	
%>
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
				<input type="password" class="form-control" id="floating-password">
				<label for=" floating-password">비밀번호</label>
			</div>
		</form>
		<div class="compelte-container">
			<button type="button" class="complete-button">로그인</button>
			<a href="${requestScope.requestURL}/register" class="move-anchor">등록된 계정이 없으십니까?</a>
		</div>
		</button>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
			integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
			crossorigin="anonymous"></script>
	</div>
</body>
</html>