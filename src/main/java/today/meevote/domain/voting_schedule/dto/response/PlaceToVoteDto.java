package today.meevote.domain.voting_schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
public class PlaceToVoteDto {
    @Schema(description = "장소 투표 항목 ID", defaultValue = "1")
    private long placeToVoteId;
    @Schema(description = "장소명", defaultValue = "투썸플레이스 혜화대명로점")
    private String placeName;
    @Schema(description = "위도", defaultValue = "37.58375581671956")
    private String lat;
    @Schema(description = "경도", defaultValue = "127.00105574106274")
    private String lng;
    @Schema(description = "득표수", defaultValue = "2")
    private int votedCount;
}
