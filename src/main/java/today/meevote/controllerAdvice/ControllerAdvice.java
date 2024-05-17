package today.meevote.controllerAdvice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import today.meevote.exception.view.UnauthenticatedException;
import today.meevote.exception.view.NotFoundException;


@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
	
    @ExceptionHandler(UnauthenticatedException.class)
    public String unauthenticatedException(UnauthenticatedException e){
    	log.error("unauthenticatedException", e);
        return "redirect:/hello";
    }
    
    @ExceptionHandler(NotFoundException.class)
    public String notFoundException(NotFoundException e) {
    	log.error("notFoundException", e);
    	return "redirect:/notfound";
    }
}
