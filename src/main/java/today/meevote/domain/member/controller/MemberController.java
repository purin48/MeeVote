package today.meevote.domain.member.controller;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
import today.meevote.domain.member.dto.reponse.GetMemberForInviteDto;
import today.meevote.domain.member.dto.reponse.GetMyInfoDto;
import today.meevote.domain.member.dto.request.EditMyInfoDto;
import today.meevote.domain.member.dto.request.EditMyPasswordDto;
import today.meevote.domain.member.service.MemberService;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;
import today.meevote.utils.SessionUtil;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/member")
@Tag(name = "회원 API 명세서")
@Validated
public class MemberController {
	
	private final MemberService memberService;
	
	
	@Operation(summary = "내 정보 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))   
    @GetMapping("/me")
    public DataResponse<GetMyInfoDto> getMyInfo(){
    	return new DataResponse<>(SuccessInfo.GET_MY_INFO, memberService.getMyInfo());
    }
	
	
	@Operation(summary = "내 정보 수정")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "파일 업로드 실패", value = "{\"isSuccess\": false, \"code\": \"Y00\", \"message\": \"파일 업로드가 실패했습니다. 다시 시도해주세요.\"}"),
        @ExampleObject(name = "비어있는 파일", value = "{\"isSuccess\": false, \"code\": \"Y01\", \"message\": \"파일이 비어있습니다.\"}"),
        @ExampleObject(name = "유효하지않은 파일 확장자", value = "{\"isSuccess\": false, \"code\": \"Y02\", \"message\": \"유효하지않은 파일 확장자입니다.\"}"),       
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
	@PutMapping(path = "/me", consumes = MULTIPART_FORM_DATA_VALUE)
	public BaseResponse editMyInfo(
			@Valid @RequestPart(name = "request body") EditMyInfoDto editMyInfoDto,
			@RequestPart(name = "image file", required = false) MultipartFile file) {
		memberService.editMyInfo(editMyInfoDto, file);
		return new BaseResponse(SuccessInfo.UPDATE_ME);
	}
	
	
	@Operation(summary = "내 비밀번호 수정")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "비밀번호 불일치", value = "{\"isSuccess\": false, \"code\": \"B03\", \"message\": \"비밀번호가 일치하지 않습니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
	@PutMapping(path = "/me/password")
	public BaseResponse editMyPassword(@Valid @RequestBody EditMyPasswordDto editMyPasswordDto) {
		memberService.editMyPassword(editMyPasswordDto);
    	SessionUtil.getSession(false).invalidate();
		return new BaseResponse(SuccessInfo.UPDATE_PASSWORD);
	}
	
	@Operation(summary = "초대할 회원 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "본인 조회", value = "{\"isSuccess\": false, \"code\": \"B04\", \"message\": \"본인을 초대할 수 없습니다.\"}"),
        @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
	@GetMapping("/invite")
	public DataResponse<GetMemberForInviteDto> getMemberForInvite(
    	    @Schema(description = "이메일", defaultValue = "test@gmail.com")
    	    @NotBlank(message = "이메일을 입력해주세요.")
    	    @Email(message = "유효한 이메일 형식이 아닙니다.")
    		String email) {
		return new DataResponse<>(SuccessInfo.GET_MEMBER_FOR_INVITE,
								memberService.getMemberForInvite(email));
	}
    
}
