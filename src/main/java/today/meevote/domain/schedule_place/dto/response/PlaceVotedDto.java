package today.meevote.domain.schedule_place.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceVotedDto {
    private long placeVotedId;
    private long placeVotingItemsId;
}
