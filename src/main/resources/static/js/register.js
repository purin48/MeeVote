// baseUrl 선언
const fullURL = window.location.href;
const path = window.location.pathname;
const baseURL = fullURL.replace(path, "");

// 입력값 유효성 관련 변수 선언
let emailCode;
let emailValidation = false;
let emailCodeValidation = false;
let passwordValidation = false;
let passwordCheckValidation = false;
let nameValidation = false;
let phoneValidation = false;
let addressValidation = false;


// 함수 - 이메일 중복 체크
$("#email-container >.input-btn").click(function (e) {
  // 이메일 중복 체크 ajax
  $.ajax({
    type: "GET",
    url: '/api/auth/mail/duplicate',
    dataType: "json",
    contentType: "application/json",
    data: { email: $("#email-input").val() },
    success: function (response) {
      if (response.isSuccess) {
        // 유효한 이메일 입력값
        emailValidation = true;
        $("#email-input").removeClass("is-invalid");
        $("#email-input").addClass("is-valid");
        $("#email-container > .valid-feedback").text(response.message);
        $("#email-code-input").removeClass("is-invalid");
        $("#email-input").attr("disabled", "true");
      } else {
        // 유효하지 않은 이메일 입력값
        emailValidation = false;
        $("#email-input").removeClass("is-valid");
        $("#email-input").addClass("is-invalid");
        $("#email-container > .invalid-feedback").text(response.message);
      }
    },
  });
});

// 함수 - 이메일 확인 코드 전송
$("#email-code-container > .input-btn").click(function (e) {
  if (!emailValidation) {
    // 이메일 유효성 검사가 통과되지 못한 경우
    $("#email-input").addClass("is-invalid");
    $("#email-container > .invalid-feedback").text("이메일을 먼저 입력하세요");
    return;
  } else if (!emailCodeValidation) {
    // 아직 이메일 코드 확인을 받지 못한 경우
    $("#email-code-input").removeAttr("disabled");
    $("#email-container > .valid-feedback").text("");
    $.ajax({
      type: "GET",
      url: '/api/auth/mail/code',
      dataType: "json",
      contentType: "application/json",
      data: { email: $("#email-input").val() },
      success: function (data) {
        emailCode = String(data.data.code);
      },
    });
  }
});

// 함수 - 이메일 확인 코드 입력
$("#email-code-input").keyup(function (e) {
  if ($(this).val() === emailCode) {
    $(this).attr("disabled", "true");
    $(this).removeClass("is-invalid");
    $(this).addClass("is-valid");
    emailCodeValidation = true;
  }
});

// 함수 - 비밀번호 정규식 검증
const pwReg = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
$("#password-input").keyup(function (e) {
  // 비밀번호 확인란 초기화
  $("#password-check-input").removeClass("is-invalid");
  $("#password-check-input").removeClass("is-valid");
  passwordCheckValidation = false;
  if (pwReg.test($(this).val())) {
    // 유효성 검증 통과
    passwordValidation = true;
    $(this).removeClass("is-invalid");
    $(this).addClass("is-valid");
  } else {
    // 유효성 검증 통과 X
    passwordValidation = false;
    $(this).removeClass("is-valid");
    $(this).addClass("is-invalid");
  }
});

// 함수 - 비밀번호 확인
$("#password-check-input").keyup(function (e) {
  if ($(this).val() === $("#password-input").val()) {
    // 비밀번호와 일치
    passwordCheckValidation = true;
    $(this).removeClass("is-invalid");
    $(this).addClass("is-valid");
  } else {
    // 비밀번호와 불일치
    passwordCheckValidation = false;
    $(this).removeClass("is-valid");
    $(this).addClass("is-invalid");
  }
});

// 함수 - 이름 검사
$("#name-input").keyup(function (e) {
  if ($(this).val().length > 0) {
    $(this).removeClass("is-invalid");
    $(this).addClass("is-valid");
    nameValidation = true;
  } else {
    $(this).removeClass("is-valid");
    $(this).addClass("is-invalid");
    nameValidation = false;
  }
});

// 함수 - 전화번호 정규식 검사
const phoneReg = /^010-\d{4}-\d{4}$/;
$("#phone-number-input").keyup(function (e) {
  if (phoneReg.test($(this).val())) {
    $(this).addClass("is-valid");
    $(this).removeClass("is-invalid");
    phoneValidation = true;
  } else {
    $(this).addClass("is-invalid");
    $(this).removeClass("is-valid");
    phoneValidation = false;
  }
});

// 함수 - 주소 검색
$("#address-container > .input-btn").click(function (e) {
  new daum.Postcode({
    oncomplete: function (data) {
      var addr = ""; // 주소 변수

      //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
      if (data.userSelectedType === "R") {
        addr = data.roadAddress;
      } else {
        addr = data.jibunAddress;
      }
      $('#address-input').val(addr);
      $('#address-input').addClass('is-valid');
      addressValidation = true;
    },
  }).open();
});

// 회원가입 - 입력값 검증
$('.complete-button').click(function(e) {
  if (!emailValidation) {
    focusInvalidInput('#email-input');
  } else if (!emailCodeValidation) {
    focusInvalidInput('#email-code-input');
  } else if (!passwordValidation) {
    focusInvalidInput('#password-input')
  } else if (!passwordCheckValidation) {
    focusInvalidInput('#password-check-input')
  } else if (!nameValidation) {
    focusInvalidInput('#name-input')
  } else if (!phoneValidation) {
    focusInvalidInput('#phone-number-input')
  } else if (!addressValidation) {
    focusInvalidInput('#address-input')
  } else {
    const data = {
      "email": $('#email-input').val(),
      "password": $('#password-input').val(),
      "name": $('#name-input').val(),
      "phoneNumber": $('#phone-number-input').val(),
      "address": $('#address-input').val()
    }; 
    $.ajax({
      type: "POST",
      url: '/api/auth/register',
      dataType: "json",
      contentType: "application/json",
      data: JSON.stringify(data),
      success: function (response) {
        if (response.isSuccess) {
          // 회원 가입 성공
          Swal.fire({
            title: '회원가입이 완료되었습니다',
            icon: 'success',
            confirmButtonColor: '#4fd1c5',
            confirmButtonText: '로그인',
            // showConfirmButton: false
          }).then((result) => {
            if(result.isConfirmed) {
              window.location.href = '/login'
            }
          });
        } else {
          // 회원 가입 실패
        }
      },
    });
  }
})


// 함수 - 유효하지 않은 입력값 포커싱
function focusInvalidInput(selector) {
  $(selector).removeClass('is-valid');
  $(selector).addClass('is-invalid');
  $(selector).focus();
}