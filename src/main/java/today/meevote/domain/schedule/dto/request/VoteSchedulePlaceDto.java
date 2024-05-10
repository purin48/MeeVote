package today.meevote.domain.schedule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoteSchedulePlaceDto {
    private long scheduleId;

    private List<Long> selectedPlaceIdList;
}
