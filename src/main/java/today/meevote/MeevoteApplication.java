package today.meevote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:secure.properties")
public class MeevoteApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeevoteApplication.class, args);
	}

}
