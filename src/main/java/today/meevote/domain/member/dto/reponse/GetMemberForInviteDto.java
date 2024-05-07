package today.meevote.domain.member.dto.reponse;

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
}
