package today.meevote.domain.schedule_date.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import today.meevote.domain.schedule_date.dto.request.FixScheduleDateDto;
import today.meevote.domain.schedule_date.dto.request.VoteScheduleDateDto;
import today.meevote.domain.schedule_date.dto.response.GetScheduleToDateVoteDto;
import today.meevote.response.BaseResponse;
import today.meevote.response.DataResponse;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "모임 일정 일시 API 명세서")
@RequestMapping("/schedule/date")
public class ScheduleDateController {

    @Operation(summary = "일시 투표 중인 일정 상세보기(미완)")
    @GetMapping("/vote")
    public DataResponse<GetScheduleToDateVoteDto> getScheduleToDateVote(long scheduleId){
        // 조인 지옥
        // 일정이 존재하는지 확인
        // 요청자가 이 일정의 참여자인지 확인
        // 이게 일정 투표중 인지 확인
        // 조인을 하고
        // 요청자가 이 일정의 일정장인지 확인
        return null;
    }

    @Operation(summary = "일시 투표 요청하기(미완)")
    @PostMapping("/vote")
    public BaseResponse voteScheduleDate(@Valid @RequestBody VoteScheduleDateDto voteScheduleDateDto){
        // 일정이 존재하는지 확인
        // 요청자가 이 일정의 참여자인지 확인
        // 이게 일정 투표중 인지 확인(데드라인 확인해야함)
        // 일정 투표를 하는데 기존에 했던 투표를 다 지우고 삽입
        // 투표를 하면 시간 테이블만 재렌더링되는 api 분리하기
        return null;
    }

    @Operation(summary = "모임장이 일시 투표 확정하기(미완)")
    @PostMapping("/fix")
    public BaseResponse fixScheduleDate(@Valid @RequestBody FixScheduleDateDto fixScheduleDateDto){
        // 일정이 존재하는지 확인
        // 요청자가 이 일정의 모임장인지 확인
        // 시간 투표 데드라인이 지났고 장소 투표가 시작이 안됐는지 확인
        return null;
    }
}
