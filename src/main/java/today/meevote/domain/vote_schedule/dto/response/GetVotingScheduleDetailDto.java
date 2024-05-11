package today.meevote.domain.vote_schedule.dto.response;

import lombok.*;

import java.util.List;

@Getter
@Builder
public class GetVotingScheduleDetailDto {
    private VotingScheduleInfoDto votingScheduleInfo;
    private List<PlaceToVoteDto> placeToVoteList;
    private List<VotingScheduleMemberDto> memberList;

}
