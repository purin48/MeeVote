package today.meevote.domain.schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMyScheduleListDto {
	@Schema(description = "일정 ID", defaultValue = "1")
	private long scheduleId;
	
	@Schema(description = "일정명", defaultValue = "SPRINGBOOT 스터디")
	private String name;
	
	@Schema(description = "일정 카테고리 ID", defaultValue = "2")
	private Long scheduleCategoryId;
	
	@Schema(description = "일정 카테고리 이름", defaultValue = "스터디")
	private String scheduleCategoryName;
	
	@Schema(description = "일정 색깔", defaultValue = "green")
	private String scheduleColor;
	
	@Schema(description = "그룹 일정 여부", defaultValue = "true")
	private Boolean isGroup;
	
	@Schema(description = "일정 기간", defaultValue = "7")
	private int duration;
	
	@Schema(description = "시작일시", defaultValue = "2024-05-11 09:00")
	private String startDate;
	
	@Schema(description = "종료일시", defaultValue = "2024-05-17 18:00")
	private String endDate;
	
	@Schema(description = "장소명", defaultValue = "한성대학교 중소기업직업훈련컨소시엄")
	private String placeName;
	
}
