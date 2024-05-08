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
		<!-- 폼태그 -->
		<form class="form-container">
			<!-- 이메일 -->
			<div class="input-group" id="email-container">
				<span class="input-group-text"><i class="bi bi-envelope"></i></span>
				<input type="email" class="form-control" id="email-input" placeholder="이메일">
				<button class="input-btn" type="button">중복확인</button>
				<div class="valid-feedback"></div>  
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 이메일 체크 -->
			<div class="input-group" id="email-code-container">
				<span class="input-group-text" id="eamil-code-input"><i class="bi bi-envelope-open-fill"></i></span>
				<input type="email" class="form-control" id="email-code-input" placeholder="이메일 확인 코드" disabled>
				<button class="input-btn" type="button">전송</button>
				<div class="invalid-feedback"></div>  
			</div>
			<!-- 비밀번호-->
			<div class="input-group" id="password-container">
				<span class="input-group-text"><i class="bi bi-shield-lock"></i></span>
				<input type="password" class="form-control" id="password-input" placeholder="비밀번호">
				<div class="invalid-feedback">비밀번호는 알파벳, 숫자와 특수문자를 모두 포함해야하며 8자리 이상이어야 합니다.</div>  
			</div>
			<!-- 비밀번호 체크 -->
			<div class="input-group" id="password-check-container">
				<span class="input-group-text"><i class="bi bi-shield-lock-fill"></i></span>
				<input type="password" class="form-control" id="password-check-input" placeholder="비밀번호 확인">
				<div class="invalid-feedback">비밀번호와 일치하지 않습니다.</div>  
			</div>
			<!-- 이름 -->
			<div class="input-group" id="name-container">
				<span class="input-group-text"><i class="bi bi-person"></i></span>
				<input type="text" class="form-control" id="name-input" placeholder="이름">
				<div class="invalid-feedback">이름을 입력해주세요.</div>  
			</div>
			<!-- 전화번호 -->
			<div class="input-group" id="phone-number-container">
				<span class="input-group-text"><i class="bi bi-telephone"></i></span>
				<input type="text" class="form-control" id="phone-number-input" placeholder="전화 번호">
				<div class="invalid-feedback">유효한 전화번호 형식이 아닙니다(010-oooo-oooo).</div>  
			</div>
			<!-- 주소 -->
			<div class="input-group" id="address-container">
				<span class="input-group-text"><i class="bi bi-house"></i></span>
				<input type="text" class="form-control" id="address-input" placeholder="주소" readonly>
				<button class="input-btn" type="button">검색</button>
				<div class="invalid-feedback">주소를 입력해주세요.</div>  
			</div>
		</form>
		<!-- 폼태그 End-->
		<!-- 회원가입 버튼 -->
		<div class="compelte-container">
			<button type="button" class="complete-button">회원가입</button>
			<a href="${requestScope.requestURL}/login" class="move-anchor">이미 가입한 계정이 있으십니까?</a>
		</div>
		<!-- 회원가입 버튼 End-->
		<!-- 주소 검색창 iframe
		<div id="layer" style="display:none;position:fixed;overflow:hidden;z-index:1;-webkit-overflow-scrolling:touch;">
			<img src="//t1.daumcdn.net/postcode/resource/images/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
		</div> -->
	</div>
	<!-- 주소 검색창 iframe End-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="js/register.js"></script>
</body>
</html>