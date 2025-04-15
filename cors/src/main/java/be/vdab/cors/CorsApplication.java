package be.vdab.cors;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CorsApplication {

	public static void main(String[] args) {

		SpringApplication.run(CorsApplication.class, args);
	}

	@Bean  // http://localhost:8080/swagger-ui.html
	OpenAPI openAPI() {
		return new OpenAPI().info(new Info().title("Rekenen").version("1.0.0")
				.description("Berekeningen maken"));
	}
}
