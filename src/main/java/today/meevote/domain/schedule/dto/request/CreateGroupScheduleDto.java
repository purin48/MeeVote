package today.meevote.domain.schedule.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateGroupScheduleDto {

    @NotBlank(message = "일정 이름을 입력해주세요.")
    @Schema(description = "일정명", defaultValue = "일정명1")
    private String name;

    private int scheduleDuration;

    @Min(value=1, message = "카테고리를 선택해주세요.")
    @Schema(description = "일정 카테고리 ID", defaultValue = "1")
    private int scheduleCategoryId;

    private int dateVoteDuration;

    @Schema(description = "일정 설명", defaultValue = "일정 설명입니다.")
    private String description;

    private List<String> inviteEmailList;

    private List<String> startDateList;
}
