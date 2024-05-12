package today.meevote.domain.member.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import today.meevote.domain.auth.dto.request.RegisterDto;
import today.meevote.domain.member.dto.response.GetMemberForInviteDto;
import today.meevote.domain.member.dto.response.GetMyInfoDto;
import today.meevote.domain.member.dto.request.EditMyInfoDto;

@Mapper
public interface MemberDao {
	
	public boolean isExistByEmail(String email);

	public void insert(@Param("registerDto") RegisterDto registerDto, 
					   @Param("defaultProfileImgSrc") String defaultProfileImgSrc);

	public String findPasswordByEmail(String email);
	
	public Optional<GetMyInfoDto> findMyInfoByEmail(String email);
	
	public void update(@Param("email") String email, 
            				 @Param("editMyInfoDto") EditMyInfoDto editMyInfoDto, 
        				 	 @Param("imgSrc") String imgSrc);


	public void updatePassword(@Param("email") String email, 
			 				   @Param("password") String password);
	
	public Optional<GetMemberForInviteDto> findMemberForInviteByEmail(String email);

	public List<GetMemberForInviteDto> searchMemberListByName(@Param("name") String name, @Param("email") String email);
}
