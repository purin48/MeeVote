package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetScheduleListToVoteDto {

    private long scheduleId;

    private String name;

    private String categoryName;
    private String categoryColor;

    private boolean isDateVote;
    private boolean isPlaceVote;

    private String voteDeadline;

}
