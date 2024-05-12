package today.meevote.domain.member.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetMemberForInviteDto {
	
	@Schema(description = "이메일", defaultValue = "test@gmail.com")
	private String email;
	
	@Schema(description = "이름", defaultValue = "김철수")
	private String name;

	@Schema(description = "프로필 이미지 경로", defaultValue = "default.jpg")
	private String imgSrc;
}
