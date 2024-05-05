package today.meevote.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum SuccessInfo {
	REGISTER("회원가입이 완료되었습다."),
	LOGIN("로그인이 성공하였습니다."), 
	LOGOUT("로그아웃이 완료되었습니다."), 
	GET_MY_INFO("내 정보 조회가 완료되었습니다."), 
	GET_MAIL_CODE("메일 인증코드를 전송했습니다."),
	;
	

    private final String code = "A00";
    private final String message;
}

