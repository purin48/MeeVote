// baseUrl 선언
const fullURL = window.location.href;
const path = window.location.pathname;
const baseURL = fullURL.replace(path, "");

// ----- 회원정보 GET -----
$(function () {
  $.ajax({
    type: "GET",
    url: `${baseURL}/api/member/me`,
    dataType: "json",
    contentType: "application/json",
    success: function (response) {
      if (!response.isSuccess) {
        // 예외 처리
        return;
      }
      // 회원정보 사이드바 하단에 넣기
      $('#profile-img').attr('src', response.data.imgSrc);
      $('#info-name').text(response.data.name);
      $('#info-email').text(response.data.email);
    }
  });
});
// ----- 회원정보 GET End -----


// ----- 로그아웃 -----
$('#logout-btn').click(function(e) {
  $.ajax({
    type: "POST",
    url: `${baseURL}/api/auth/logout`,
    dataType: "json",
    contentType: "application/json",
    success: function (response) {
      if (!response.isSuccess) {
        // 예외 처리
        return;
      }
      window.location.replace(`${baseURL}/login`);
    }
  });
})
// ----- 로그아웃 End -----


// ----- 사이드바 토글 -----
$('#nav-delete-btn').click(function(e) {
  $('.side-nav').addClass('nav-toggle');
  $('#nav-create-btn').css('display', 'block');
})

$('#nav-create-btn').click(function(e) {
  $('.side-nav').removeClass('nav-toggle');
  $(this).css('display', 'none');
})

//