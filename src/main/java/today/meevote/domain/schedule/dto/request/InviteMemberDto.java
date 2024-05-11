package today.meevote.domain.schedule.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InviteMemberDto {

    private long scheduleId;
    private String email;
}
