package today.meevote.domain.schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleCategoryDto {
	
	@Schema(description = "일정 카테고리 ID", defaultValue = "2")
	private long scheduleCategoryId;
	
	@Schema(description = "일정 카테고리 이름", defaultValue = "스터디")
	private String categoryName;
	
	@Schema(description = "일정 색깔", defaultValue = "green")
	private String color;
}
