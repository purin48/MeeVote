package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleToDateVoteDto {
    private long scheduleId;
    private long scheduleCategoryId;
    private String scheduleCategoryName;
    private String scheduleColor;
    private String name;
    private String description;
    private int duration;
    private String dateVoteDeadline;
    private List<DateVotingItemsDto> dateVotingItems;
    private List<ScheduleMemberDateDto> memberList;
    private boolean isRequesterOwner;
}
