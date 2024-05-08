package today.meevote.domain.auth.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import today.meevote.domain.auth.dto.request.LoginDto;
import today.meevote.domain.auth.dto.request.RegisterDto;
import today.meevote.domain.etc.service.S3Service;
import today.meevote.domain.member.dao.MemberDao;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;
import today.meevote.utils.SessionUtil;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;
	
	@Value("${default-profile-img-src}")
    private String defaultProfileImgSrc;
	
	public void register(RegisterDto registerDto) {
		if(memberDao.isExistByEmail(registerDto.getEmail())) {
			throw new RestException(FailureInfo.ALREADY_EXIST_MEMBER);
		}
		registerDto.setPassword(passwordEncoder.encode(registerDto.getPassword()));		
		memberDao.insert(registerDto, defaultProfileImgSrc);
	}

	public void login(LoginDto loginDto) {
		String password = memberDao.findPasswordByEmail(loginDto.getEmail());
        if (password == null || !passwordEncoder.matches(loginDto.getPassword(), password)) {
            throw new RestException(FailureInfo.NOT_EXIST_MEMBER);
        }	
		SessionUtil.getSession(true).setAttribute("email", loginDto.getEmail());
	}

	public void checkEmailDuplication(String email) {
		if(memberDao.isExistByEmail(email)) {
			throw new RestException(FailureInfo.ALREADY_EXIST_MEMBER);
		}		
	}
}
