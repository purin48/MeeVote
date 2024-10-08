package today.meevote.response;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class DataResponse<T> extends BaseResponse {
    private final T data;
    public DataResponse(SuccessInfo successInfo, T data) {
        super(successInfo);
        this.data = data;
    }
}
