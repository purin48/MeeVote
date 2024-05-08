package today.meevote.domain.auth.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import today.meevote.domain.auth.dto.request.LoginDto;
import today.meevote.domain.auth.dto.request.RegisterDto;
import today.meevote.domain.auth.service.AuthService;
import today.meevote.domain.etc.dto.response.GetMailCodeDto;
import today.meevote.domain.etc.service.MailService;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;
import today.meevote.utils.SessionUtil;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
@Tag(name = "인증 API 명세서")
@Validated
public class AuthController {
	
	private final AuthService authService;
	private final MailService mailService;
	
	@Operation(summary = "회원가입")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "이미 존재하는 회원", value = "{\"isSuccess\": false, \"code\": \"B00\", \"message\": \"이미 존재하는 회원입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))   
	@PostMapping("/register")	
	public BaseResponse register(@Valid @RequestBody RegisterDto registerDto) {
		authService.register(registerDto);
		return new BaseResponse(SuccessInfo.REGISTER);
	}
    
	@Operation(summary = "로그인")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))   
    @PostMapping("/login")
    public BaseResponse login(@Valid @RequestBody LoginDto loginDto) {
		authService.login(loginDto);
    	return new BaseResponse(SuccessInfo.LOGIN);
    }
    
	@Operation(summary = "로그아웃")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))   
    @PostMapping("/logout")
    public BaseResponse logout() {
    	SessionUtil.getSession(false).invalidate();
        return new BaseResponse(SuccessInfo.LOGOUT);
    }
	
	@Operation(summary = "메일 인증 코드 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
	    @ExampleObject(name = "메일인증코드 전송실패", value = "{\"isSuccess\": false, \"code\": \"B02\", \"message\": \"인증 코드를 보내는데 실패했습니다. 유효한 메일인지 확인 후 다시 시도해주세요.\"}"),		
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
    @GetMapping("/mail/code")
    public DataResponse<GetMailCodeDto> getMailCode(
    	    @Schema(description = "이메일", defaultValue = "test@gmail.com")
    	    @NotBlank(message = "이메일을 입력해주세요.")
    	    @Email(message = "유효한 이메일 형식이 아닙니다.")
    		String email){
    	return new DataResponse<>(SuccessInfo.GET_MAIL_CODE, mailService.getMailCode(email));
    }
	
	
	@Operation(summary = "이메일 중복검사")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "이미 존재하는 회원", value = "{\"isSuccess\": false, \"code\": \"B00\", \"message\": \"이미 존재하는 회원입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))  
	@GetMapping("/mail/duplicate")
	public BaseResponse checkEmailDuplication(
			@Schema(description = "이메일", defaultValue = "test@gmail.com")
    	    @NotBlank(message = "이메일을 입력해주세요.")
    	    @Email(message = "유효한 이메일 형식이 아닙니다.")
			String email) {
		
		authService.checkEmailDuplication(email);
		return new BaseResponse(SuccessInfo.VALID_EMAIL);
	}
}
