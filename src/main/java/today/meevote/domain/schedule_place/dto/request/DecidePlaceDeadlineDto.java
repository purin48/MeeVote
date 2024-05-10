package today.meevote.domain.schedule_place.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DecidePlaceDeadlineDto {
    private long scheduleId;
    private String placeVoteDeadline;
}
