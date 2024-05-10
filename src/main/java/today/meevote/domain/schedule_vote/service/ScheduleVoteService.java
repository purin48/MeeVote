package today.meevote.domain.schedule_vote.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.domain.schedule.dto.response.GetScheduleListDto;
import today.meevote.domain.schedule_vote.dao.ScheduleVoteDao;
import today.meevote.domain.schedule_vote.dto.response.GetVoteScheduleListDto;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleVoteService {

    private final ScheduleVoteDao scheduleVoteDao;

    public List<GetVoteScheduleListDto> getVoteScheduleList() {
        String email = MemberContextHolder.getEmail();
        return scheduleVoteDao.getVoteScheduleList(email);
    }
}
