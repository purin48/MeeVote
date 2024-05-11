package today.meevote.domain.vote_schedule.dto.request;

import lombok.Getter;

@Getter
public class CreatePlaceDto {
    private long scheduleId;
    private String placeName;
    private String lat;
    private String lng;
}
