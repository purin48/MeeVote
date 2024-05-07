package today.meevote.domain.etc.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import today.meevote.domain.etc.dto.response.GetMailCodeDto;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

@Service
@RequiredArgsConstructor
@Slf4j
public class MailService {

	private final JavaMailSender mailSender;
	
	@Value("${spring.mail.username}")
	private String fromMail;
	
	private int code;
	
    public GetMailCodeDto getMailCode(String email) {
    	try {
        	MimeMessage message = createMail(email);
        	mailSender.send(message);
            return new GetMailCodeDto(code);
    	}catch(Exception e) {
    		log.error("exception", e);
    		throw new RestException(FailureInfo.CODE_SEND_FAIL);
    	}
    }
    
    public MimeMessage createMail(String email){
        code = new Random().nextInt(900000) + 100000;
        MimeMessage message = mailSender.createMimeMessage();

        try {
			message.setFrom(fromMail);
            message.setRecipients(MimeMessage.RecipientType.TO, email); 
            message.setSubject("[Meevote] 회원가입을 위한 이메일 인증");  
            String body = "";
            body += "<h1>" + "안녕하세요." + "</h1>";
            body += "<h1>" + "Meevote 입니다." + "</h1>";
            body += "<h3>" + "회원가입을 위한 요청하신 인증 번호입니다." + "</h3><br>";
            body += "<h2>" + "아래 코드를 회원가입 창으로 돌아가 입력해주세요." + "</h2>";

            body += "<div align='center' style='border:1px solid black; font-family:verdana;'>";
            body += "<h2>" + "회원가입 인증 코드입니다." + "</h2>";
            body += "<h1 style='color:blue'>" + code + "</h1>";
            body += "</div><br>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body, "UTF-8", "html");
            
		} catch (Exception e) {
			log.error("exception", e);
			throw new RestException(FailureInfo.CODE_SEND_FAIL);
		}
        
        return message;
    }
}
