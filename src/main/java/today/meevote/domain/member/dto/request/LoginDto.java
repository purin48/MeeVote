package today.meevote.domain.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {
	
    @NotBlank(message = "이메일을 입력해주세요.")
    @Schema(description = "이메일", defaultValue = "test@gmail.com")
    @Email(message = "유효한 이메일 형식이 아닙니다.")
	private String email;
    
    @Schema(description = "비밀번호", defaultValue = "test1234!")
    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
    		 message = "비밀번호는 알파벳, 숫자와 특수문자를 모두 포함해야하며 8자리 이상이어야 합니다.")
	private String password;
}
