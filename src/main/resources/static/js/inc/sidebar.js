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




// ----- 회원정보 업데이트 ajax -----
async function updateProfile(name, phoneNumber, address, imageData) {
  const formData = new FormData();
  formData.append('image file', imageData); // 이미지 파일 추가
  formData.append('request body', JSON.stringify({
    "name": name,
    "address": address,
    "phoneNumber": phoneNumber
  }));

  const response = await $.ajax({
      url: '/api/member/me',
      type: 'PUT',
      data: formData,
      processData: false,
      contentType: false,
      headers: {
        'accept': 'application/json;charset=UTF-8'
      },
  });

  if (!response.isSuccess) {
    // 예외 처리
  }

  console.log(response)

  return response
}
// ----- 회원정보 업데이트 ajax -----



// ----- 프로필 사진 
$('.profile-img-container').click(async function() {
  const fileInput = $('<input type="file" accept="image/*" style="display: none;" />');

  fileInput.on('change', function() {
      const file = fileInput[0].files[0];
      const reader = new FileReader();

      reader.onload = async function(event) {
        const imageData = event.target.result;
        await updateProfile(myInfo.name, myInfo.phoneNumber, myInfo.address, fileInput[0].files[0]);
        $('#profile-img').attr('src', imageData);
      };

      reader.readAsDataURL(file);
  });

  fileInput.click(); // 파일 선택 창 열기
});


