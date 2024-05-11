package today.meevote.domain.vote_schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
public class VotingScheduleInfoDto {
    @Schema(description = "일정 ID", defaultValue = "1")
    private long scheduleId;
    @Schema(description = "카테고리 ID", defaultValue = "2")
    private long scheduleCategoryId;
    @Schema(description = "카테고리명", defaultValue = "스터디")
    private String categoryName;
    @Schema(description = "색상", defaultValue = "green")
    private String color;
    @Schema(description = "일정명", defaultValue = "스프링부트 스터디")
    private String name;
    @Schema(description = "일정 설명", defaultValue = "스프링부트 마스터하기")
    private String description;
    @Schema(description = "시작일시", defaultValue = "2024-05-20 09:00")
    private String startDate;
    @Schema(description = "시작일시", defaultValue = "2024-05-20 23:00")
    private String endDate;
    @Schema(description = "투표마감일시", defaultValue = "2024-05-18 23:00")
    private String voteDeadline;
    @Schema(description = "요청자가 모임장이면 true, 아니면 false", defaultValue = "true")
    private Boolean isRequesterOwner;
}
