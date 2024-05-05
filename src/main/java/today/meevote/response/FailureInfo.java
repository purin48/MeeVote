package today.meevote.response;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum FailureInfo {
	
	// 공통 (~Z99)
    INTERNAL_SERVER_ERROR("Z99", "서버 오류가 발생했습니다."),
    INVALID_INPUT("Z98", "입력값이 유효하지 않습니다."),
    UNAUTHENTICATED("Z97", "인증되지않은 요청입니다."),

    // 회원 (B00~ )
    ALREADY_EXIST_MEMBER("B00", "이미 존재하는 회원입니다."), 
    NOT_EXIST_MEMBER("B01", "존재하지 않는 회원입니다."), 
    CODE_SEND_FAIL("B02", "인증코드 전송을 실패했습니다. 유효한 메일인지 확인 후 다시 시도해주세요."),
    
    ;

    
    private final String code;
    private final String message;

}
