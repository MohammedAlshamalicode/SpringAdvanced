package be.vdab.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;
// enkele andere imports
@Configuration
class SecurityConfig {
    @Bean
    SecurityFilterChain geefRechten(HttpSecurity http) throws Exception {
        http.oauth2Login(withDefaults());
        http.authorizeHttpRequests(
                        requests-> requests.requestMatchers("/", "/index.html")
                                .permitAll()
                .requestMatchers("/beveiligd.html", "/user", "/beveiligd.js").authenticated());
        return http.build();
    }
}