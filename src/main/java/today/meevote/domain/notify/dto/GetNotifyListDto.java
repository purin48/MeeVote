package today.meevote.domain.notify.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class GetNotifyListDto {

    @Schema(description = "알림 ID", defaultValue = "1")
    private long notifyId;
    @Schema(description = "알림 카테고리 ID", defaultValue = "1")
    private long notifyCategoryId;
    @Schema(description = "알림 카테고리명", defaultValue = "모임 일정 초대")
    private String notifyCategoryName;
    @Schema(description = "알림 메시지", defaultValue = "모임 일정에 초대되었습니다. 장소 투표에 참여하세요.")
    private String message;
    @Schema(description = "읽었는지?", defaultValue = "false")
    private Boolean isRead;
    @Schema(description = "일정 ID", defaultValue = "1")
    private long scheduleId;
    @Schema(description = "일정명", defaultValue = "스프링부트 스터디")
    private String name;
    @Schema(description = "일정 카테고리명", defaultValue = "스터디")
    private String scheduleCategoryName;
    @Schema(description = "색상", defaultValue = "green")
    private String color;
    @Schema(description = "시작일시", defaultValue = "2024-05-08 09:00")
    private String startDate;
    @Schema(description = "종료일시", defaultValue = "2024-05-10 23:00")
    private String endDate;
    @Schema(description = "모임여부", defaultValue = "true")
    private Boolean isGroup;
    @Schema(description = "투표 마감일시", defaultValue = "2024-05-05 10:00")
    private String voteDeadline;
    @Schema(description = "약속장소명", defaultValue = "null")
    private String placeName;




}
