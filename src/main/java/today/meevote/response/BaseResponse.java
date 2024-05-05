package today.meevote.response;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class BaseResponse {
	
    @Schema(description = "성공여부", defaultValue = "true")
    private final Boolean isSuccess;
    @Schema(description = "결과코드(상태코드 X)", defaultValue = "A00")
    private final String code;
    @Schema(description = "결과메시지", defaultValue = "요청이 성공하였습니다.")
    private final String message;

    public BaseResponse(SuccessInfo successInfo){
        this.isSuccess = true;
        this.code = successInfo.getCode();
        this.message = successInfo.getMessage();
    }

    public BaseResponse(FailureInfo failureInfo){
        this.isSuccess = false;
        this.code = failureInfo.getCode();
        this.message = failureInfo.getMessage();
    }
}
