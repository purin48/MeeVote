package today.meevote.domain.member.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.domain.etc.service.S3Service;
import today.meevote.domain.member.dao.MemberDao;
import today.meevote.domain.member.dto.reponse.GetMemberForInviteDto;
import today.meevote.domain.member.dto.reponse.GetMyInfoDto;
import today.meevote.domain.member.dto.request.EditMyInfoDto;
import today.meevote.domain.member.dto.request.EditMyPasswordDto;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberDao memberDao;
	private final PasswordEncoder passwordEncoder;
	private final S3Service s3Service;
	
	public GetMyInfoDto getMyInfo(){
		return memberDao.findMyInfoByEmail(MemberContextHolder.getEmail())
				.orElseThrow(() -> new RestException(FailureInfo.NOT_EXIST_MEMBER));
	}

	public void editMyInfo(EditMyInfoDto editMyInfoDto, MultipartFile file) {
		String email = MemberContextHolder.getEmail();
		if(!memberDao.isExistByEmail(email)) {
			throw new RestException(FailureInfo.NOT_EXIST_MEMBER);
		}
		String imgSrc = null;
		if(file != null) {
			imgSrc = s3Service.uploadProfileImage(file); 
		}
		memberDao.update(email, editMyInfoDto, imgSrc);
	}

	public void editMyPassword(EditMyPasswordDto editMyPasswordDto) {
		String email = MemberContextHolder.getEmail();
		String password = memberDao.findPasswordByEmail(email);
        if (password == null) {
            throw new RestException(FailureInfo.NOT_EXIST_MEMBER);
        }
    	if(!passwordEncoder.matches(editMyPasswordDto.getOldPassword(), password)) {
            throw new RestException(FailureInfo.NOT_CORRECT_PASSWORD);
        }	
		memberDao.updatePassword(email, passwordEncoder.encode(editMyPasswordDto.getNewPassword()));
	}

	public GetMemberForInviteDto getMemberForInvite(String email) {
		String myEmail = MemberContextHolder.getEmail();
		
		if(email.equals(myEmail)) 
			throw new RestException(FailureInfo.SELF_INVITE);
		
		return memberDao.findMemberForInviteByEmail(email)
			.orElseThrow(() -> new RestException(FailureInfo.NOT_EXIST_MEMBER));
	}
}
