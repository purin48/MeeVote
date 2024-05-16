package today.meevote.controllerAdvice;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import today.meevote.exception.rest.RestException;
import today.meevote.response.BaseResponse;
import today.meevote.response.FailureInfo;
@Slf4j
@org.springframework.web.bind.annotation.RestControllerAdvice
public class RestControllerAdvice {
	
    @ExceptionHandler(Exception.class)
    protected BaseResponse internalSeverException(Exception e){
    	log.error("internalSeverException", e);
        return new BaseResponse(FailureInfo.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected BaseResponse methodArgumentNotValidException(MethodArgumentNotValidException e){
    	log.error("invalidInputException", e);
        return new BaseResponse(
                false,
                FailureInfo.INVALID_INPUT.getCode(),
                e.getFieldError().getDefaultMessage()
        );
    }
    
    @ExceptionHandler(ConstraintViolationException.class)
    protected BaseResponse constraintViolationException(ConstraintViolationException e){
    	log.error("invalidInputException", e);
        return new BaseResponse(
                false,
                FailureInfo.INVALID_INPUT.getCode(),
                e.getConstraintViolations().stream().toList().get(0).getMessage()
        );
    }

    @ExceptionHandler(RestException.class)
    protected BaseResponse restException(RestException e){
    	log.error("restException", e);
        return new BaseResponse(e.getFailureInfo());
    }
}
