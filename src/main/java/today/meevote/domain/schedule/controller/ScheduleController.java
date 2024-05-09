package today.meevote.domain.schedule.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import today.meevote.domain.schedule.dto.request.CreatePersonalScheduleDto;
import today.meevote.domain.schedule.service.ScheduleService;
import today.meevote.response.BaseResponse;
import today.meevote.response.SuccessInfo;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule")
@Tag(name = "일정 API 명세서")
@Validated
public class ScheduleController {

	private final ScheduleService scheduleService;
	
	@Operation(summary = "내 일정 생성")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "존재하지않는 카테고리", value = "{\"isSuccess\": false, \"code\": \"S01\", \"message\": \"존재하지 않는 카테고리입니다.\"}"),
        @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
        @ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
	@PostMapping("/personal")
	public BaseResponse createPersonalSchedule(@Valid @RequestBody CreatePersonalScheduleDto dto) {
		scheduleService.createPersonalSchedule(dto);
		return new BaseResponse(SuccessInfo.CREATE_SCHEDULE);
	}
	
	@Operation(summary = "내 일정 삭제")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
	    content = @Content(examples = {
        @ExampleObject(name = "존재하지않는 회원", value = "{\"isSuccess\": false, \"code\": \"B01\", \"message\": \"존재하지않는 회원입니다.\"}"),
        @ExampleObject(name = "존재하지않는 일정", value = "{\"isSuccess\": false, \"code\": \"S02\", \"message\": \"존재하지 않는 일정입니다.\"}"),
        @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
        @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
    }))
	@DeleteMapping("/personal")
	public BaseResponse deletePersonalSchedule(
			@Schema(description = "스케줄 id", defaultValue = "1")
			@Min(value=1, message = "스케줄 id값을 확인해주세요.")
			@RequestParam 
			Long scheduleId
		) {
	    scheduleService.deletePersonalSchedule(scheduleId);
	    return new BaseResponse(SuccessInfo.DELETE_SCHEDULE);
	}
	
}
