// baseUrl 선언
const fullURL = window.location.href;
const path = window.location.pathname;
const baseURL = fullURL.replace(path, "");
let myInfo = {}

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
    myInfo = response.data
    $('#profile-img').attr('src', myInfo.imgSrc);
    $('#info-name').text(myInfo.name);
    $('#info-email').text(myInfo.email);
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


// 회원 정보 수정
async function updateMemberInfo(data) {
  const response = await $.ajax({
    type: "PUT",
    url: '/api/member/me',
    dataType: "json",
    contentType: "application/json",
    data: JSON.stringify(data),
  });
  if (!response.isSuccess) {
    // 실패 시 예외 처리
  }

  return response;
}


// // ----- 배경사진 변경
// $('.profile-img-container').click(async function(e) {
//   updateMemberInfo()
//   const file  = await Swal.fire({
//     title: "배경사진 변경",
//     input: "file",
//     inputAttributes: {
//       "accept": "image/*",
//       "aria-label": "Upload your profile picture"
//     }
//   });
//   if (file) {
//     const reader = new FileReader();
//     reader.onload = (e) => {
//       Swal.fire({
//         title: "Your uploaded picture",
//         imageUrl: e.target.result,
//         imageAlt: "The uploaded picture"
//       });
//     };
//     reader.readAsDataURL(file);
//   }
// })