package today.meevote.domain.schedule.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePersonalScheduleDto {
	@NotBlank(message = "일정 이름을 입력해주세요.")
	@Schema(description = "일정명", defaultValue = "일정명1")
	private String name;
	
	@Schema(description = "일정 설명", defaultValue = "일정 설명입니다.")
	private String description;
	
	@Min(value=1, message = "카테고리를 선택해주세요.")
	@Schema(description = "일정 카테고리 ID", defaultValue = "1")
	private int scheduleCategoryId;

	@Schema(description = "일정 시작일", defaultValue = "2024-05-07 15:00")
	private String startDate;
	
	@Schema(description = "일정 종료일", defaultValue = "2024-05-08 21:00")
	private String endDate;
	
	@Schema(description = "장소", defaultValue = "서울시 혜화동")
	private String placeName;
	
	@Schema(description = "장소 위도", defaultValue = "35.97664845766847")
	private String placeLatitude;
	
	@Schema(description = "장소 경도", defaultValue = "126.99597295767953")
	private String placeLongitude;
}
