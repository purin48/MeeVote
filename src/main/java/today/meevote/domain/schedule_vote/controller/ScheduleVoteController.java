package today.meevote.domain.schedule_vote.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import today.meevote.domain.schedule.dto.response.GetScheduleListDto;
import today.meevote.domain.schedule_vote.dto.request.CreatePlaceDto;
import today.meevote.domain.schedule_vote.dto.request.DecidePlaceDto;
import today.meevote.domain.schedule_vote.dto.response.GetVoteScheduleDetailDto;
import today.meevote.domain.schedule_vote.dto.response.GetVoteScheduleListDto;
import today.meevote.domain.schedule_vote.service.ScheduleVoteService;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;
import today.meevote.response.SuccessInfo;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/schedule/vote")
@Tag(name = "투표 중인 일정 API 명세서")
@Validated
public class ScheduleVoteController {

    private final ScheduleVoteService scheduleVoteService;

    @Operation(summary = "투표 중인 일정 목록 조회")
    @GetMapping("/list")
    public DataResponse<List<GetVoteScheduleListDto>> getVoteScheduleList(){
        return new DataResponse<>(SuccessInfo.GET_VOTE_SCHEDULE_LIST,
                scheduleVoteService.getVoteScheduleList());
    }

    @Operation(summary = "투표 중인 일정 상세조회(미완)")
    @GetMapping("/detail")
    public DataResponse<GetVoteScheduleDetailDto> getVoteScheduleDetail(long scheduleId){
        return null;
    }

    @Operation(summary = "투표 중인 일정에 장소 추가하기(미완)")
    @PostMapping("/place")
    public BaseResponse createPlaceToVote(CreatePlaceDto createPlaceToVoteDto){
        return null;
    }

    @Operation(summary = "투표 중인 일정에서 내 출발지 수정(미완)")
    @PostMapping("/departure")
    public BaseResponse createDeparturePlace(CreatePlaceDto createDeparturePlaceDto){
        return null;
    }

    @Operation(summary = "장소 확정하기(미완)")
    @PostMapping("/decide")
    public BaseResponse decidePlace(DecidePlaceDto decidePlaceDto){
        return null;
    }

    @Operation(summary = "장소 투표하기(미완)")
    @PostMapping
    public BaseResponse votePlace(DecidePlaceDto votePlaceDto){
        return null;
    }
}
