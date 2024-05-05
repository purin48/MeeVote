package today.meevote.controllerAdvice;

import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;
import today.meevote.exception.view.UnauthenticatedException;
import today.meevote.exception.view.NotFoundException;

@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice {
	
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
    
}
