package today.meevote.domain.schedule_vote.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import today.meevote.domain.schedule.dto.response.GetScheduleListDto;
import today.meevote.domain.schedule_vote.dto.response.GetVoteScheduleListDto;

import java.util.List;

@Mapper
public interface ScheduleVoteDao {
    public List<GetVoteScheduleListDto> getVoteScheduleList(@Param("email") String email);
}
