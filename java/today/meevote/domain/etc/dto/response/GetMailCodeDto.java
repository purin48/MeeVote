package today.meevote.domain.etc.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetMailCodeDto {
	@Schema(description = "메일인증코드", defaultValue = "123456")
    private int code;
}
