package today.meevote.domain.schedule_vote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceToVote {
    private long placeToVoteId;
    private String placeName;
    private String lat;
    private String lng;
    private int votedCount;
}
