package today.meevote.exception.rest;

import lombok.Getter;
import today.meevote.response.FailureInfo;

@Getter
public class RestException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	private final FailureInfo failureInfo;
    
    public RestException(FailureInfo failureInfo) {
        super(failureInfo.getMessage());
        this.failureInfo = failureInfo;
    }
}