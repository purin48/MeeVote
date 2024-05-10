package today.meevote.domain.schedule.controller;

import jakarta.validation.constraints.Pattern;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.RequiredArgsConstructor;
import today.meevote.domain.schedule.dto.request.*;
import today.meevote.domain.schedule.dto.response.*;
import today.meevote.domain.schedule.service.ScheduleService;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

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

	@Operation(summary = "캘린더 일정조회")
	@ApiResponse(responseCode = "1", description = "성공")
	@ApiResponse(responseCode = "2", description = "실패",
			content = @Content(examples = {
					@ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
					@ExampleObject(name = "유효하지않은 입력값", value = "{\"isSuccess\": false, \"code\": \"Z98\", \"message\": \"입력값이 유효하지 않습니다.\"}"),
					@ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
			}))
	@GetMapping("/calendar")
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

	@Operation(summary = "모임일정 생성(미완)")
	@PostMapping("/group")
	public BaseResponse createGroupSchedule(CreateGroupScheduleDto createGroupScheduleDto){
		//모임장 및 초대된 인원들
		//member_schedule에 데이터 넣어야함
		//notify에는 모임장 빼고 초대된 인원들 데이터 넣어야함
		//schedule_vote 생성해야함
		return null;
	}

	@Operation(summary = "투표 중인 일정 목록(미완)")
	@GetMapping("/vote/list")
	public DataResponse<List<GetScheduleListToVoteDto>> getScheduleListToVote(){
		//투표가 임박한 순으로 정렬해서 리턴
		//투표 중인 걸 알기 위한 조건
		// is_group이 1
		// start_date와 end_date가 null -> 일정 투표 중임
		// start_date랑 end_date는 있는데 place_~ 다 null -> 장소 투표 중임
		// 리턴할때 이게 일정 투표 중인지 장소 투표 중인지 알려줘야함(날짜 투표 일정 상세보기랑 장소 투표 일정 상세보기랑 api가 달라서)
		return null;
	}

	@Operation(summary = "확정된 일정 상세보기(미완)")
	@GetMapping("/detail")
	public DataResponse<GetScheduleDetailDto> getScheduleDetail(long scheduleId){
		// 일정이 존재하는지 확인
		// 요청자가 이 일정의 모임장인지 확인
		// 이 일정이 찐 확정됐는지 확인
		return null;
	}

	@Operation(summary = "지난 일정목록 조회(미완)")
	@GetMapping("/past/list")
	public DataResponse<Page<GetScheduleListDto>> getPastScheduleList(long categoryId, String keyword, Pageable pageable){
		// 확정된 지난 일정(endDate가 현재 일시보다 이전일때)
		// 페이징 처리
		// 카테고리 아이디, 키워드는 필수아님
		// 최근순으로 정렬
		return null;
	}

	@Operation(summary = "예정 중인 일정목록 조회(미완)")
	@GetMapping("/future/list")
	public DataResponse<List<GetScheduleListDto>> getFutureScheduleList(){
		//현재에서 가장 가까운 순으로 정렬
		//확정된 일정
		return null;
	}


}
