package today.meevote.domain.voting_schedule.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import today.meevote.domain.voting_schedule.dto.request.CreatePlaceDto;
import today.meevote.domain.voting_schedule.dto.request.SelectPlaceDto;
import today.meevote.domain.voting_schedule.dto.response.GetVotingScheduleDetailDto;
import today.meevote.domain.voting_schedule.dto.response.GetVotingScheduleListDto;
import today.meevote.domain.voting_schedule.service.VotingScheduleService;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/voting/schedule")
@Tag(name = "투표 중인 일정 API 명세서")
@Validated
public class VotingScheduleController {

    private final VotingScheduleService votingScheduleService;

    @Operation(summary = "투표 중인 일정 목록 조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
            content = @Content(examples = {
                    @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
                    @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
            }))
    @GetMapping("/list")
    public DataResponse<List<GetVotingScheduleListDto>> getVotingScheduleList(){
        return new DataResponse<>(SuccessInfo.GET_VOTE_SCHEDULE_LIST,
                votingScheduleService.getVotingScheduleList());
    }

    @Operation(summary = "투표 중인 일정 상세조회")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
            content = @Content(examples = {
                    @ExampleObject(name = "해당 일정의 멤버가 아님", value = "{\"isSuccess\": false, \"code\": \"S99\", \"message\": \"해당 일정의 멤버가 아닙니다.\"}"),
                    @ExampleObject(name = "존재하지않는 투표일정", value = "{\"isSuccess\": false, \"code\": \"V00\", \"message\": \"존재하지않는 투표일정입니다.\"}"),
                    @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
                    @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
            }))
    @GetMapping("/detail")
    public DataResponse<GetVotingScheduleDetailDto> getVotingScheduleDetail(long scheduleId){
        return new DataResponse<>(SuccessInfo.GET_VOTE_SCHEDULE_DETAIL,
                votingScheduleService.getVotingScheduleDetail(scheduleId));
    }

    @Operation(summary = "투표 장소 추가하기")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
            content = @Content(examples = {
                    @ExampleObject(name = "해당 일정의 멤버가 아님", value = "{\"isSuccess\": false, \"code\": \"S99\", \"message\": \"해당 일정의 멤버가 아닙니다.\"}"),
                    @ExampleObject(name = "존재하지않는 투표일정", value = "{\"isSuccess\": false, \"code\": \"V00\", \"message\": \"존재하지않는 투표일정입니다.\"}"),
                    @ExampleObject(name = "이미 존재하는 장소", value = "{\"isSuccess\": false, \"code\": \"P00\", \"message\": \"이미 존재하는 장소입니다.\"}"),
                    @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
                    @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
            }))
    @PostMapping("/place")
    public BaseResponse addPlaceToVote(long scheduleId, @Valid @RequestBody CreatePlaceDto addPlaceToVoteDto){
        votingScheduleService.addPlaceToVote(scheduleId, addPlaceToVoteDto);
        return new BaseResponse(SuccessInfo.ADD_PLACE_TO_VOTE);
    }

    @Operation(summary = "장소 투표/투표취소")
    @ApiResponse(responseCode = "1", description = "성공")
    @ApiResponse(responseCode = "2", description = "실패",
            content = @Content(examples = {
                    @ExampleObject(name = "해당 일정의 멤버가 아님", value = "{\"isSuccess\": false, \"code\": \"S99\", \"message\": \"해당 일정의 멤버가 아닙니다.\"}"),
                    @ExampleObject(name = "존재하지않는 투표장소", value = "{\"isSuccess\": false, \"code\": \"P01\", \"message\": \"존재하지않는 투표장소입니다.\"}"),
                    @ExampleObject(name = "인증되지않은 요청", value = "{\"isSuccess\": false, \"code\": \"Z97\", \"message\": \"인증되지않은 요청입니다.\"}"),
                    @ExampleObject(name = "내부 서버 오류", value = "{\"isSuccess\": false, \"code\": \"Z99\", \"message\": \"서버 오류가 발생했습니다.\"}")
            }))
    @PutMapping("/place/toggle")
    public BaseResponse toggleVotePlace(long placeToVoteId){
        votingScheduleService.toggleVotePlace(placeToVoteId);
        return new BaseResponse(SuccessInfo.TOGGLE_VOTE_PLACE);
    }

    @Operation(summary = "내 출발지 수정하기(미완)")
    @PutMapping("/departure")
    public BaseResponse createDeparturePlace(CreatePlaceDto updateDeparturePlaceDto){
        return null;
    }

    @Operation(summary = "장소 확정하기(미완)")
    @PostMapping("/place/confirm")
    public BaseResponse decidePlace(SelectPlaceDto selectPlaceDto){
        return null;
    }

}
