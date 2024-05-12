package today.meevote.domain.voting_schedule.dto.request;

import lombok.Getter;

@Getter
public class SelectPlaceDto {
    private long scheduleId;
    private long placeToVoteId;
}
