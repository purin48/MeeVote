package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleMemberDto {
    private String email;
    private String name;
    private String address;
    private String imgSrc;
    private Boolean isOwner;
    private String departurePlaceName;
    private String lat;
    private String lng;
}
