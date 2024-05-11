package today.meevote.domain.vote_schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class GetVotingScheduleListDto {

    @Schema(description = "일정 ID", defaultValue = "1")
    private long scheduleId;
    @Schema(description = "일정명", defaultValue = "스프링부트 스터디")
    private String name;
    @Schema(description = "카테고리명", defaultValue = "스터디")
    private String categoryName;
    @Schema(description = "색깔", defaultValue = "green")
    private String color;
    @Schema(description = "투표 종료 일시", defaultValue = "2024-05-21 09:00")
    private String voteDeadline;
    @Schema(description = "모임 일정 여부", defaultValue = "true")
    private Boolean isGroup;
}
