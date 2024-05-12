package today.meevote.domain.voting_schedule.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.domain.voting_schedule.dao.VotingScheduleDao;
import today.meevote.domain.voting_schedule.dto.request.CreatePlaceDto;
import today.meevote.domain.voting_schedule.dto.response.*;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VotingScheduleService {

    private final VotingScheduleDao votingScheduleDao;

    public List<GetVotingScheduleListDto> getVotingScheduleList() {
        String email = MemberContextHolder.getEmail();
        return votingScheduleDao.getVotingScheduleList(email);
    }

    public GetVotingScheduleDetailDto getVotingScheduleDetail(long scheduleId) {
        String email = MemberContextHolder.getEmail();

        VotingScheduleInfoDto votingScheduleInfoDto = votingScheduleDao.getVotingScheduleInfoDto(email, scheduleId)
                        .orElseThrow(() -> new RestException(FailureInfo.NOT_EXIST_VOTING_SCHEDULE));

        List<PlaceToVoteDto> placeToVoteList = votingScheduleDao.getPlaceToVoteDtoList(scheduleId);

        List<VotingScheduleMemberDto> memberList = votingScheduleDao.getVotingScheduleMemberDtoList(scheduleId);

        return GetVotingScheduleDetailDto.builder()
                .votingScheduleInfo(votingScheduleInfoDto)
                .placeToVoteList(placeToVoteList)
                .memberList(memberList)
                .build();
    }

    public void addPlaceToVote(long scheduleId, CreatePlaceDto addPlaceToVoteDto) {
        String email = MemberContextHolder.getEmail();

        if(!votingScheduleDao.isExistVotingSchedule(scheduleId, email))
            throw new RestException(FailureInfo.NOT_EXIST_VOTING_SCHEDULE);

        if(votingScheduleDao.isExistPlaceToVote(scheduleId, addPlaceToVoteDto))
            throw new RestException(FailureInfo.ALREADY_EXIST_PLACE_TO_VOTE);

        votingScheduleDao.addPlaceToVote(scheduleId, addPlaceToVoteDto);
    }
}
