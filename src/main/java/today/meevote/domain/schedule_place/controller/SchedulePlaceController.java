package today.meevote.domain.schedule_place.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import today.meevote.domain.schedule_place.dto.request.CreateCandidatePlaceDto;
import today.meevote.domain.schedule_place.dto.request.DecidePlaceDeadlineDto;
import today.meevote.domain.schedule_place.dto.request.FixSchedulePlaceDto;
import today.meevote.domain.schedule_place.dto.request.VoteSchedulePlaceDto;
import today.meevote.domain.schedule_place.dto.response.GetScheduleToPlaceVoteDto;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "모임 일정 장소 API 명세서")
@RequestMapping("/schedule/place")
public class SchedulePlaceController {
    @Operation(summary = "모임장이 장소 투표 마감일 정하기(미완)")
    @PostMapping("/deadline")
    public BaseResponse decidePlaceDeadline(@Valid @RequestBody DecidePlaceDeadlineDto decidePlaceDeadlineDto){
        // 일정이 존재하는지 확인하고
        // 요청자가 이 일정의 모임장인지 확인
        // 이 일정이 시간투표가 확정되었고 장소 투표가 시작하지 않았는지 확인
        return null;
    }

    @Operation(summary = "장소 투표 중인 모임일정 상세조회(미완)")
    @GetMapping("/vote")
    public DataResponse<GetScheduleToPlaceVoteDto> getScheduleToPlaceVote(long scheduleId){
        // 조인 지옥
        // 일정이 존재하는지 확인하고
        // 요청자가 이 일정의 참여자인지 확인
        // 장소 투표가 진행중인지 확인 (데드라인이 지나도 장소 확정이 안되었으면 조회할수있음 단 post가 안됨)

        return null;
    }

    @Operation(summary = "장소 투표 후보지 넣기(미완)")
    @PostMapping("/candidate")
    public BaseResponse createCandidatePlace(@Valid @RequestBody CreateCandidatePlaceDto createCandidatePlaceDto){
        // 일정이 존재하는지 확인하고
        // 요청자가 이 일정의 참여자인지 확인하고
        // 이 일정이 장소투표가 진행중인지 확인
        // 장소를 추가하면 장소 후보지 목록만 재렌더링되는 api 분리하기
        return null;
    }

    @Operation(summary = "장소 투표하기(미완)")
    @PostMapping("/vote")
    public BaseResponse createCandidatePlace(@Valid @RequestBody VoteSchedulePlaceDto voteSchedulePlaceDto){
        // 일정이 존재하는지 확인하고
        // 요청자가 이 일정의 참여자인지 확인하고
        // 이게 장소 투표중 인지 확인(데드라인 확인해야함)
        // 장소 투표를 하는데 기존에 했던 투표를 다 지우고 삽입
        // 장소 투표를 하면 장소 투표 현황만 재렌더링되는 api 분리하기
        return null;
    }

    @Operation(summary = "모임장이 장소 투표 확정하기(미완)")
    @PostMapping("/fix")
    public BaseResponse fixSchedulePlace(@Valid @RequestBody FixSchedulePlaceDto fixSchedulePlaceDto){
        // 일정이 존재하는지 확인
        // 요청자가 이 일정의 모임장인지 확인
        // 일정 기간이 존재하는지, 장소 투표 데드라인이 지났는지 확인
        return null;
    }
}
