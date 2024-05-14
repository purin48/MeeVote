package today.meevote.domain.statistics.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class GetMyCategoryStatsDto {

    @Schema(description = "카테고리명", defaultValue = "스터디")
    private String categoryName;
    @Schema(description = "카테고리색", defaultValue = "green")
    private String color;
    @Schema(description = "카테고리의 일정 수", defaultValue = "11")
    private int scheduleCount;
    @Schema(description = "카테고리의 일정 퍼센트", defaultValue = "30.33")
    private double percentage;
}
