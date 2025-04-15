package be.vdab.palindroom;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PalindroomApplication {

    public static void main(String[] args) {
        SpringApplication.run(PalindroomApplication.class, args);
    }

    @Bean          ///  http://localhost:8080/swagger-ui/index.html#/woord-controller/isPalindrom  /////
    OpenAPI openAPI() {
        return new OpenAPI().info(new Info().title("Palindroom").version("1.0.0")
                .description("Palindroom API Documentation"));
    }

}
