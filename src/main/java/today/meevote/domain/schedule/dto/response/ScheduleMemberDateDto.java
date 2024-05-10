package today.meevote.domain.schedule.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleMemberDateDto {
    private String email;
    private String name;
    private String address;
    private String imgSrc;

    private List<DateVotedDto> dateVotedList;
}
