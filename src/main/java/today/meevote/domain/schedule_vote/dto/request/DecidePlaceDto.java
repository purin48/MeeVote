package today.meevote.domain.schedule_vote.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecidePlaceDto {
    private long scheduleId;
    private long placeToVoteId;
}
