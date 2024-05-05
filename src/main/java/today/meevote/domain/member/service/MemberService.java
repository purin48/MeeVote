package today.meevote.domain.member.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.domain.member.dao.MemberDao;
import today.meevote.domain.member.dto.reponse.GetMyInfoDto;
import today.meevote.domain.member.dto.request.LoginDto;
import today.meevote.domain.member.dto.request.RegisterDto;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;
import today.meevote.utils.SessionUtil;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;
	
	public void register(RegisterDto registerDto) {
		if(memberDao.isExistMember(registerDto.getEmail())) {
			throw new RestException(FailureInfo.ALREADY_EXIST_MEMBER);
		}
		registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));		
		memberDao.createMember(registerDto);
	}

	public void login(LoginDto loginDto) {
		loginDto.setPassword(passwordEncoder.encode(loginDto.getPassword()));
		if(!memberDao.isExistMember(loginDto)) {
			throw new RestException(FailureInfo.NOT_EXIST_MEMBER);
		}
		SessionUtil.getSession(true).setAttribute("email", loginDto.getEmail());
	}
	
	public GetMyInfoDto getMyInfo(){
		GetMyInfoDto getMyInfoDto = memberDao.getMember(MemberContextHolder.getEmail())
				.orElseThrow(() -> new RestException(FailureInfo.NOT_EXIST_MEMBER));
		return getMyInfoDto;		
	}

}
