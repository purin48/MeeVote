package today.meevote.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import today.meevote.contextholder.MemberContextHolder;
import today.meevote.exception.rest.RestException;
import today.meevote.response.FailureInfo;

public class RestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        
        if(request.getSession(false) == null || request.getSession(false).getAttribute("email") == null) {
            throw new RestException(FailureInfo.UNAUTHENTICATED);
        }
        
        MemberContextHolder.setEmail((String)request.getSession(false).getAttribute("email"));
        
        return true;
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
    	MemberContextHolder.clear();
    }
}
