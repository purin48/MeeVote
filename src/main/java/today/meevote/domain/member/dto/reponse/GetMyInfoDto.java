package today.meevote.domain.member.dto.reponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class GetMyInfoDto {
	@Schema(description = "이름", defaultValue = "김철수")
	private String name;
	
	@Schema(description = "주소", defaultValue = "서울특별시 서대문구 거북골로 34")
	private String address;
	
	@Schema(description = "이메일", defaultValue = "test@gmail.com")
	private String email;
	
	@Schema(description = "전화번호", defaultValue = "010-1234-5678")
	private String phoneNumber;
	
	@Schema(description = "프로필이미지 경로", defaultValue = "default.jpg")
	private String imgSrc;

}
