package today.meevote.domain.schedule.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import jakarta.validation.Valid;
import today.meevote.domain.schedule.dto.request.CreatePersonalScheduleDto;

@Mapper
public interface ScheduleDao {
	
	public boolean isExistByEmail(String email);
	
	public boolean isCategoryExist(int categoryId);
	
    public void createPersonalSchedule(Map<String, Object> dto);
    
    public void createMemberSchedule(@Param("email") String email, @Param("scheduleId") long scheduleId);

	public boolean isExistScheduleByInfo(@Param("email") String email, @Param("scheduleId") long scheduleId);

	public void deleteMemberSchedule(Long scheduleId);

	public void deletePersonalSchedule(Long scheduleId);
	
}
