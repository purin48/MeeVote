// 로그인 버튼 로직
$('.compelte-container > button').click(function (e) { 
  // baseUrl 선언
  const fullURL = window.location.href;
  const path = window.location.pathname;
  const baseURL = fullURL.replace(path, '');

  // 변수 등록
  const email  = $('#email-input').val();
  const password = $('#password-input').val();

  console.log(email, password)

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
        $('.compelte-container > p').css("display", "block");
      }
    },
  });
});
// 로그인 버튼 로직 End