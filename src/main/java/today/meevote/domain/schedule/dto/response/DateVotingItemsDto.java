package today.meevote.domain.schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateVotingItemsDto {
    private long dateVotingItemsId;
    private String startDate;
    private String endDate;
}
