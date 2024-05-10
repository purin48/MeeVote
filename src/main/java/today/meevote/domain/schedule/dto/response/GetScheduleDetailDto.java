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
    private String categoryName;
    private String color;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private Boolean isGroup;
    private String placeName;
    private String lat;
    private String lng;
    private List<ScheduleMemberDto> scheduleMemberList;
    private boolean isRequesterOwner;
}
