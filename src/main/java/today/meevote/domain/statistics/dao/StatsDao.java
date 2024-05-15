package today.meevote.domain.statistics.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import today.meevote.domain.statistics.dto.response.GetMyCategoryStatsDto;
import today.meevote.domain.statistics.dto.response.GetMyScheduleStatsDto;

import java.util.List;

@Mapper
public interface StatsDao {
    public List<GetMyCategoryStatsDto> getMyCategoryStats(@Param("email") String email, @Param("isGroup") Boolean isGroup, @Param("year") String year, @Param("month") String month);

    public List<GetMyScheduleStatsDto> getMyScheduleStats(@Param("email") String email, @Param("isGroup") Boolean isGroup, @Param("categoryId") Long categoryId, @Param("year") String year);
}
