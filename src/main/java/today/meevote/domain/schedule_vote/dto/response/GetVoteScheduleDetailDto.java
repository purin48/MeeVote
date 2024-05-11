package today.meevote.domain.schedule_vote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetVoteScheduleDetailDto {
    private long scheduleId;
    private long scheduleCategoryId;
    private String categoryName;
    private String color;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String voteDeadline;
    private List<PlaceToVote> placeToVoteList;
    private List<ScheduleMemberVoteDto> memberList;
    private Boolean isRequesterOwner;
}
