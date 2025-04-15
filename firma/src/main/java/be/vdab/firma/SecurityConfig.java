package be.vdab.firma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    private final DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Bean
    JdbcUserDetailsManager maakPrincipals() {
        var manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery("""
                select emailAdres as username, paswoord as password, true as enabled
                from werknemers
                where emailAdres = ?
                """);
        manager.setAuthoritiesByUsernameQuery("""
                select emailAdres, authority
                from werknemers
                where emailAdres = ?
                """);
        return manager;
    }

    @Bean
    SecurityFilterChain geefRechten(HttpSecurity http) throws Exception {
        http.formLogin(withDefaults());
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/", "/index.html").permitAll()
                .requestMatchers("/geluk.html").hasAuthority("gebruiker"));
        return http.build();
    }
}
