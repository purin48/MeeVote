package today.meevote.domain.voting_schedule.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreatePlaceDto {
    @Schema(description = "장소명", defaultValue = "작심스터디카페 대학로점")
    @NotBlank(message = "장소명을 입력해주세요.")
    private String placeName;
    @Schema(description = "위도", defaultValue = "37.58159029999999")
    @NotBlank(message = "위도를 입력해주세요.")
    private String lat;
    @Schema(description = "경도", defaultValue = "127.0028113")
    @NotBlank(message = "경도를 입력해주세요.")
    private String lng;
}
