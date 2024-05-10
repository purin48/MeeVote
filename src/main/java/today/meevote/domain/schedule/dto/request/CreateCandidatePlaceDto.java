package today.meevote.domain.schedule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCandidatePlaceDto {

    private long scheduleId;
    private String placeName;
    private String placeLatitude;
    private String placeLongitude;
}
