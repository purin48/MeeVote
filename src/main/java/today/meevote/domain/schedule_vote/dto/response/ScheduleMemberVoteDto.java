package today.meevote.domain.schedule_vote.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleMemberVoteDto {
    private String email;
    private String name;
    private String address;
    private String imgSrc;
    private boolean isOwner;
    private String departurePlaceName;
    private String lat;
    private String lng;
    private List<PlaceVotedDto> placeVotedList;
}
