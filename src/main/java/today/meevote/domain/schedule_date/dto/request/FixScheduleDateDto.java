package today.meevote.domain.schedule_date.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixScheduleDateDto {
    private long scheduleId;
    private String startDate;
    private String endDate;
}
