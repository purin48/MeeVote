package today.meevote.domain.vote_schedule.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import today.meevote.domain.vote_schedule.dto.response.GetVotingScheduleListDto;
import today.meevote.domain.vote_schedule.dto.response.PlaceToVoteDto;
import today.meevote.domain.vote_schedule.dto.response.VotingScheduleInfoDto;
import today.meevote.domain.vote_schedule.dto.response.VotingScheduleMemberDto;

import java.util.List;
import java.util.Optional;

@Mapper
public interface VotingScheduleDao {
    public List<GetVotingScheduleListDto> getVotingScheduleList(String email);

    public Optional<VotingScheduleInfoDto> getVotingScheduleInfoDto(@Param("email") String email, @Param("scheduleId") long scheduleId);

    public List<PlaceToVoteDto> getPlaceToVoteDtoList(long scheduleId);

    public List<VotingScheduleMemberDto> getVotingScheduleMemberDtoList(long scheduleId);
}
