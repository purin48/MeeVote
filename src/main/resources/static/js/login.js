// baseUrl 선언
const fullURL = window.location.href;
const path = window.location.pathname;
const baseURL = fullURL.replace(path, '');

// 함수 - 로그인
function login() {
  // 변수 등록
  const email  = $('#email-input').val();
  const password = $('#password-input').val();
  // 로그인 정보 비동기로 전송
  $.ajax({
    type: "POST",
    url: `${baseURL}/api/auth/login`,
    dataType : "json",
    contentType: "application/json",
    data : JSON.stringify({'email': email, 'password': password}),
    success: function(data) {
      if (data.isSuccess) {
        window.location.href = `${baseURL}`;
      } else {
        $('.complete-container > p').css("display", "block");
      }
    },
  });
}

// 이벤트 등록 - 로그인 버튼
$('.complete-container > button').click(function (e) { 
  login();
});

// 이벤트 등록 - 패스워드 입력창
$('#password-input').keypress(function (e) { 
  login();
});
