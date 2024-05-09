package today.meevote.domain.schedule.controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import today.meevote.domain.schedule.dto.response.GetMyScheduleListDto;
import today.meevote.domain.schedule.dto.response.GetScheduleCategoryDto;
import today.meevote.domain.schedule.service.ScheduleV2Service;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedule")
@Tag(name = "일정 API 명세서")
@Validated
public class ScheduleV2Controller {
	
	private final ScheduleV2Service scheduleService;
	
	@Operation(summary = "내 일정목록 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "본인 조회", value = "{\"isSuccess\": false, \"code\": \"B04\", \"message\": \"본인을 초대할 수 없습니다.\"}"),
        @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
	@GetMapping("/me/list")
	public DataResponse<List<GetMyScheduleListDto>> getMyScheduleList(
			@RequestParam(required = false)
			Boolean isGroup, 
			
    	    @Schema(description = "년도", defaultValue = "2024")
    	    @NotBlank(message = "년도를 입력해주세요.")
			@Pattern(regexp = "^[1-9]\\d{3}$", message = "올바른 년도 형식이 아닙니다.")
			String year,
			
    	    @Schema(description = "월", defaultValue = "05")
    	    @NotBlank(message = "월을 입력해주세요.")
			@Pattern(regexp = "^(0[1-9]|1[0-2])$", message = "올바른 월 형식이 아닙니다.")
			String month){
				
		return new DataResponse<>(SuccessInfo.GET_MY_SCHEDULE_LIST, 
								  scheduleService.getMyScheduleList(isGroup, year, month));			
	}

	@Operation(summary = "일정 카테고리 조회")
	@ApiResponse(responseCode = "1", description = "성공")
	@ApiResponse(responseCode = "2", description = "실패",
			content = @Content(examples = {
					@ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
					@ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
			}))
	@GetMapping("/category")
	public DataResponse<List<GetScheduleCategoryDto>> getScheduleCategory(){
		return new DataResponse<>(SuccessInfo.GET_SCHEDULE_CATEGORY, scheduleService.getCategory());

	}
}
