package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleListDto {

    private long scheduleId;
    private String categoryName;
    private boolean isGroup;
    private String color;
    private String name;
    private String startDate;
    private String placeName;
}