package today.meevote.domain.schedule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleListDto {

    private long scheduleId;
    private String scheduleCategoryName;
    private String scheduleColor;
    private String name;
    private String startDate;
    private String placeName;
}
