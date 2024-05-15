package today.meevote.domain.statistics.dao;

import org.apache.ibatis.annotations.Mapper;
import today.meevote.domain.statistics.dto.response.GetMyCategoryStatsDto;
import today.meevote.domain.statistics.dto.response.GetMyScheduleStatsDto;

import java.util.List;

@Mapper
public interface StatsDao {
    public List<GetMyCategoryStatsDto> getMyCategoryStats(String email, Boolean isGroup, String year, String month);

    public List<GetMyScheduleStatsDto> getMyScheduleStats(String email, Boolean isGroup, Long categoryId, String year);
}
