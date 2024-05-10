package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlaceVotingItemsDto {
    private long placeVotingItemsId;
    private String placeName;
    private String placeLatitude;
    private String placeLongitude;
}
