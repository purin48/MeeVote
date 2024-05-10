// baseUrl 선언
const fullURL = window.location.href;
const path = window.location.pathname;
const baseURL = fullURL.replace(path, "");

// ----- 회원정보 GET -----
$.ajax({
  type: "GET",
  url: '/api/member/me',
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


// ----- 회원정보 GET End -----


// ----- 로그아웃 -----
$('#logout-btn').click(function(e) {
  $.ajax({
    type: "POST",
    url: '/api/auth/logout',
    dataType: "json",
    contentType: "application/json",
    success: function (response) {
      if (!response.isSuccess) {
        // 예외 처리
        return;
      }
      // 뒤로가기 방지
      window.location.replace('/login');
    }
  });
})
// ----- 로그아웃 End -----


// ----- 사이드바 토글 -----
$('#nav-delete-btn').click(function(e) {
  $('.side-nav').css('left', -230);
  $('#nav-create-btn').css('display', 'flex');
})

$('#nav-create-btn').click(function(e) {
  $('.side-nav').css('left', 0);
  $('#nav-create-btn').css('display', 'none');
})
// ----- 사이드바 토글 End -----


// ----- 윈도우 리사이징시 사이드바 조작 -----
  $(window).resize(function() {
    const windowWidth = $(window).width();
    if (windowWidth <= 800) {
      $('.side-nav').css('left', -230);
      $('#nav-create-btn').css('display', 'flex');
    } else {
      $('.side-nav').css('left', 0);
      $('#nav-create-btn').css('display', 'none');
    }
});
// 


// ----- 페이지 이동
const menuList = ['', 'table', 'create/personal', 'create/group'];
$.each($('.nav-content').children(), function (index, el) {
  $(el).click(function(e) {
    window.location.href = `/${menuList[index]}`;
  })
});