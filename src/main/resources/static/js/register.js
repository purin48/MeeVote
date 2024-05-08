// baseUrl 선언
const fullURL = window.location.href;
const path = window.location.pathname;
const baseURL = fullURL.replace(path, '');

// 입력값 유효성 관련 변수 선언
let emailValidation = false;
let emailCodeValidation = false;
let passwordValidation = false;
let passwordCheckValidation = false;
let nameValidation = false;
let phoneValidation = false;

// 입력값 저장 변수
let emailCode;

// 함수 - 이메일 중복 체크
$('#email-container >.input-btn').click(function (e) {
  // 이메일 중복 체크 ajax
  $.ajax({
    type: "GET",
    url: `${baseURL}/api/auth/mail/duplicate`,
    dataType : "json",
    contentType: "application/json",
    data : {'email': $('#email-input').val()},
    success: function(data) {
      if (data.isSuccess) {  // 유효한 이메일 입력값
        emailValidation = true;
        $('#email-input').removeClass('is-invalid');
        $('#email-input').addClass('is-valid');
        $('#email-container > .valid-feedback').text(data.message);
        $('#email-code-input').removeClass('is-invalid')
        $('#email-input').attr('disabled', 'true');
      } else {  // 유효하지 않은 이메일 입력값
        emailValidation = false;
        $('#email-input').removeClass('is-valid');
        $('#email-input').addClass('is-invalid');
        $('#email-container > .invalid-feedback').text(data.message);
      }
    },
  });
});

// 함수 - 이메일 확인 코드 전송
$('#email-code-container > .input-btn').click(function(e) {
  if(!emailValidation) {
    // 이메일 유효성 검사가 통과되지 못한 경우
    console.log("awrgaerhe")
    $('#email-input').addClass('is-invalid')
    $('#email-container > .invalid-feedback').text("이메일을 먼저 입력하세요");
    return;
  } else if (!emailCodeValidation) {
    // 아직 이메일 코드 확인을 받지 못한 경우
    $.ajax({
      type: "GET",
      url: `${baseURL}/api/auth/mail/code`,
      dataType : "json",
      contentType: "application/json",
      data : {'email': $('#email-input').val()},
      success: function(data) {
          emailCode = String(data.data.code);
          $('#email-code-input').removeAttr('disabled');
      },
    });
  }
})

// 함수 - 이메일 확인 코드 입력
$('#email-code-input').keyup(function (e) {
  if($(this).val() === emailCode) {
    $(this).attr('disabled', 'true');
    $(this).addClass('is-valid');
  }
});


// 함수 - 비밀번호 정규식 검증
const pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
$('#password-input').keyup(function(e) {
  // 비밀번호 확인란 초기화
  $('#password-check-input').removeClass('is-invalid');
  $('#password-check-input').removeClass('is-valid');
  passwordCheckValidation = false;
  if (pwReg.test($(this).val())) {
    // 유효성 검증 통과
    passwordValidation = true;
    $(this).removeClass('is-invalid');
    $(this).addClass('is-valid');
  } else {
    // 유효성 검증 통과 X
    passwordValidation = false;
    $(this).removeClass('is-valid');
    $(this).addClass('is-invalid');
  }
})

// 함수 - 비밀번호 확인 
$('#password-check-input').keyup(function(e) {
  if ($(this).val() === $('#password-input').val()) {
    // 비밀번호와 일치
    passwordCheckValidation = true;
    $(this).removeClass('is-invalid');
    $(this).addClass('is-valid');
  } else {
    // 비밀번호와 불일치
    passwordCheckValidation = false;
    $(this).removeClass('is-valid');
    $(this).addClass('is-invalid');
  }
})

// 함수 - 이름 검사
$('#name-input').keyup(function(e) {
  if($(this).val().length > 0) {
    $(this).removeClass('is-invalid');
    $(this).addClass('is-valid');
    nameValidation = true;
  } else {
    $(this).removeClass('is-valid');
    $(this).addClass('is-invalid');
    nameValidation = false;
  }
})


// 함수 - 전화번호 정규식 검사
const phoneReg = /^010-\d{4}-\d{4}$/;
$('#phone-number-input').keyup(function(e) {
  if (phoneReg.test($(this).val())) {
    $(this).addClass('is-valid');
    $(this).removeClass('is-invalid');
    phoneValidation = true;
  } else {
    $(this).addClass('is-invalid');
    $(this).removeClass('is-valid');
    phoneValidation = false;
  }
})


// 함수 - 주소 검색
$('#address-container > .input-btn').click(function(e) {
  // 주소 검색창 iframe에 할당
  new daum.Postcode({
    oncomplete: function(data) {

      },
  }).open();
})
