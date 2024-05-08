package today.meevote.domain.schedule.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.domain.schedule.dao.ScheduleV2Dao;
import today.meevote.domain.schedule.dto.response.GetMyScheduleListDto;

@Service
@RequiredArgsConstructor
public class ScheduleV2Service {
	
	private final ScheduleV2Dao scheduleDao;
	
	public List<GetMyScheduleListDto> getMyScheduleList(Boolean isGroup, String year, String month) {
		String email = MemberContextHolder.getEmail();
		return scheduleDao.getMyScheduleList(email, isGroup, year, month);
	}
}
