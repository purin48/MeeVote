package today.meevote.domain.statistics.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.domain.schedule.dao.ScheduleDao;
import today.meevote.domain.statistics.dao.StatsDao;
import today.meevote.domain.statistics.dto.response.GetMyCategoryStatsDto;
import today.meevote.domain.statistics.dto.response.GetMyScheduleStatsDto;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatsService {

    private final StatsDao statsDao;
    private final ScheduleDao scheduleDao;
    public List<GetMyCategoryStatsDto> getMyCategoryStats(Boolean isGroup, String year, String month) {
        String email = MemberContextHolder.getEmail();
        return statsDao.getMyCategoryStats(email, isGroup, year, month);
    }

    public List<GetMyScheduleStatsDto> getMyScheduleStats(Boolean isGroup, Long categoryId, String year) {
        String email = MemberContextHolder.getEmail();

        if(categoryId != null && !scheduleDao.isCategoryExist(categoryId))
            throw new RestException(FailureInfo.NOT_EXIST_CATEGORY);

        return statsDao.getMyScheduleStats(email, isGroup, categoryId, year);
    }
}
