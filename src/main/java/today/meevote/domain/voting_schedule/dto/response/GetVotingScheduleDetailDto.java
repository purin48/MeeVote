package today.meevote.domain.voting_schedule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.List;

@Getter
@Builder
public class GetVotingScheduleDetailDto {
    private VotingScheduleInfoDto votingScheduleInfo;
    private List<PlaceToVoteDto> placeToVoteList;
    private List<VotingScheduleMemberDto> memberList;
    @Schema(description = "요청자가 모임장이면 true, 아니면 false", defaultValue = "true")
    private Boolean isRequesterOwner;

}
