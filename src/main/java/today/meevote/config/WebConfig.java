package today.meevote.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import today.meevote.interceptor.RestInterceptor;
import today.meevote.interceptor.ViewInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {
        
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
        registry.addInterceptor(new ViewInterceptor())
        		.excludePathPatterns(
        				"/api/**",
        				"/register",
        				"/login",
        				"/v3/api-docs",
        				"/swagger",
        				"/swagger-ui.html", 
        				"/swagger-ui/**", 
        				"/v3/api-docs/**", 
        				"/swagger-resources/**",
        				"/css/**",
        				"/js/**",
        				"/image/**"
        				)
        		.addPathPatterns("/**");
        
        registry.addInterceptor(new RestInterceptor())
				.excludePathPatterns(
						"/api/auth/register",
						"/api/auth/mail/code",
						"/api/auth/login"
						)
				.addPathPatterns("/api/**");
    }
}
