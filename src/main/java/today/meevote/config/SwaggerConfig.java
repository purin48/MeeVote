package today.meevote.config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Component
public class SwaggerConfig {

  @Bean
  public OpenAPI api() {
    Info info = new Info()
      .title("Meevote API 문서");
    return new OpenAPI()
      .info(info);
  }
}
