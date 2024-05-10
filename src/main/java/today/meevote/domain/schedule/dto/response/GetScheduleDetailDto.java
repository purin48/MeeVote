package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleDetailDto {

    private long scheduleId;
    private long scheduleCategoryId;
    private String scheduleCategoryName;
    private String scheduleColor;
    private String name;
    private String description;
    private boolean isGroup;
    private int duration;
    private String startDate;
    private String endDate;
    private String placeName;
    private String placeLatitude;
    private String placeLongitude;

    private List<ScheduleMemberDto> memberList;
}
