package today.meevote.domain.member.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditMyPasswordDto {
	
    @Schema(description = "기존 비밀번호", defaultValue = "test1234!")
    @NotBlank(message = "기존 비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
    		 message = "비밀번호는 알파벳, 숫자와 특수문자를 모두 포함해야하며 8자리 이상이어야 합니다.")
	private String oldPassword;
    
    @Schema(description = "새 비밀번호", defaultValue = "test1234!")
    @NotBlank(message = "새 비밀번호를 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$", 
    		 message = "비밀번호는 알파벳, 숫자와 특수문자를 모두 포함해야하며 8자리 이상이어야 합니다.")
	private String newPassword;
}
