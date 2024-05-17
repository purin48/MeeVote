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
	<!-- js import -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous" defer></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js" defer></script>
	<style>
		body {
			margin: 0;
			padding: 0;
			height: 100vh;
			width: 100vw;
			display: flex;
			justify-content: center;
			align-items: center;
			background: url('/image/onboarding/onboarding.svg') no-repeat center center;
			background-size: cover;
			background-attachment: fixed;
		}

		.container {
			text-align: center;
			color: #fff; /* 텍스트 색상을 흰색으로 설정하여 배경과 구분 */
		}

		.container h1 {
			margin: 0;
			font-size: 3em;
		}

		.container h2 {
			margin-top: 10px;
			font-size: 1.5em;
		}

		.login-button {
			position: absolute;
			bottom: 50px; /* 버튼을 화면 하단에서 50px 위로 이동 */
			left: 50%;
			transform: translateX(-50%);
			padding: 10px 20px;
			font-size: 1em;
			color: #fff;
			background-color: #4fd1c4;
			border: none;
			border-radius: 5px;
			cursor: pointer;
		}

		.login-button:hover {
			background-color: #3b9b91;
			transition: all 0.3s;
		}
	</style>
</head>

<body>
	<div class="container">
		<button class="login-button" onclick="window.location.href='/login'">로그인하기</button>
	</div>
</body>
</html>