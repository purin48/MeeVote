package today.meevote.domain.schedule.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import today.meevote.domain.schedule.dto.response.GetMyScheduleListDto;
import today.meevote.domain.schedule.dto.response.GetScheduleCategoryDto;

@Mapper
public interface ScheduleV2Dao {

	List<GetMyScheduleListDto> getMyScheduleList(
			@Param("email")
			String email, 
			@Param("isGroup")
			Boolean isGroup, 
			@Param("year")
			String year, 
			@Param("month")
			String month);


	List<GetScheduleCategoryDto> getCategory();
}
