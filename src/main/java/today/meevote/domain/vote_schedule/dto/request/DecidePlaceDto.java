package today.meevote.domain.vote_schedule.dto.request;

import lombok.Getter;

@Getter
public class DecidePlaceDto {
    private long scheduleId;
    private long placeToVoteId;
}
