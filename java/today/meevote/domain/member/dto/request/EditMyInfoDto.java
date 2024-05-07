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
public class EditMyInfoDto {
	
    @Schema(description = "이름", defaultValue = "김철수")
    @NotBlank(message = "이름을 입력해주세요.")
	private String name;
    
    @Schema(description = "주소", defaultValue = "서울특별시 서대문구 거북골로 34")
    @NotBlank(message = "주소를 입력해주세요.")
	private String address;
    
    @Schema(description = "휴대폰 번호", defaultValue = "010-1234-5678")
    @NotBlank(message = "휴대폰 번호를 입력해주세요.")
    @Pattern(regexp = "^010-\\d{4}-\\d{4}$", 
    		 message = "유효한 전화번호 형식이 아닙니다.")
	private String phoneNumber;
}
