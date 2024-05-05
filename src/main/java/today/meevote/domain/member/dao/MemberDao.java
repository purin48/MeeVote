package today.meevote.domain.member.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import today.meevote.domain.member.dto.reponse.GetMyInfoDto;
import today.meevote.domain.member.dto.request.LoginDto;
import today.meevote.domain.member.dto.request.RegisterDto;

@Mapper
public interface MemberDao {
	
	public boolean isExistMember(String email);

	public void createMember(RegisterDto registerDto);

	public boolean isExistMember(LoginDto loginDto);

	public Optional<GetMyInfoDto> getMember(String email);

}
