package today.meevote.domain.statistics.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class GetMyScheduleStatsDto {

    @Schema(description = "월", defaultValue = "05")
    private String month;
    @Schema(description = "일정 수", defaultValue = "13")
    private String scheduleCount;
}
