package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleToPlaceVoteDto {
    private long scheduleId;
    private long scheduleCategoryId;
    private String scheduleCategoryName;
    private String scheduleColor;
    private String name;
    private String description;
    private int duration;
    private String startDate;
    private String endDate;
    private String placeVoteDeadline;
    private List<PlaceVotingItemsDto> placeVotingItems;
    private List<ScheduleMemberPlaceDto> memberList;
    private boolean isRequesterOwner;
}
