package today.meevote.controllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import today.meevote.exception.view.UnauthenticatedException;
import today.meevote.exception.view.NotFoundException;
import today.meevote.response.BaseResponse;
import today.meevote.response.FailureInfo;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
    @ExceptionHandler(UnauthenticatedException.class)
    public String unauthenticatedException(UnauthenticatedException e){
    	log.error("unauthenticatedException", e);
        return "redirect:/login";
    }
    
    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(NotFoundException e) {
    	log.error("notFoundException", e);
    	return "redirect:/notfound";
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
}
