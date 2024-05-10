package today.meevote.domain.schedule_vote.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePlaceDto {
    private long scheduleId;
    private String placeName;
    private String lat;
    private String lng;
}
