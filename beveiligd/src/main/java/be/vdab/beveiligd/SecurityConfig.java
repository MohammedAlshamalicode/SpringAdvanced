package be.vdab.beveiligd;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

import static org.springframework.security.config.Customizer.withDefaults;


/// Client secrets////////////2b5a2de5ba5368c7ad5c4bdf571f89a9c5c61e49///////////////



// enkele andere imports
@Configuration
class SecurityConfig {
    private static final String MANAGER = "manager";
    private static final String HELPDESKMEDEWERKER = "helpdeskmedewerker";
    private static final String MAGAZIJNIER = "magazijnier";
    private final DataSource dataSource;

    SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

//    @Bean
//    InMemoryUserDetailsManager maakPrincipals() {
//        var joe = User.withUsername("joe")
//                .password("{noop}theboss")
//                .authorities(MANAGER)
//                .build();
//        var averell = User.withUsername("averell").password("{noop}hungry")
//                .authorities(HELPDESKMEDEWERKER, MAGAZIJNIER)
//                .build();
//        return new InMemoryUserDetailsManager(joe, averell);      ///  (1)
//    }

    @Bean
    JdbcUserDetailsManager maakPrincipals() {
//        return new JdbcUserDetailsManager(dataSource); //// (2)

        var manager = new JdbcUserDetailsManager(dataSource);
        manager.setUsersByUsernameQuery(
        """
        select naam as username, paswoord as password, actief as enabled
        from gebruikers
        where naam = ?
        """);
        manager.setAuthoritiesByUsernameQuery(
        """
        select gebruikers.naam as username, rollen.naam as authorities
        from gebruikers inner join gebruikersrollen
        on gebruikers.id = gebruikersrollen.gebruikerId
        inner join rollen on rollen.id = gebruikersrollen.rolId
        where gebruikers.naam = ?
        """);
        return manager;

    }

    @Bean
    SecurityFilterChain geefRechten(HttpSecurity http) throws Exception {
        http.formLogin(withDefaults());
        http.authorizeHttpRequests(requests -> requests
                .requestMatchers("/images/**", "/css/**", "/js/**", "/", "/index.html", "/accessDenied.html", "/principal")
                .permitAll()
                .requestMatchers("/bestellingen.html", "/bestellingen/**")
                .hasAuthority(MANAGER)
                .requestMatchers("/werknemers.html", "/werknemers/**")
                .hasAnyAuthority(MAGAZIJNIER, HELPDESKMEDEWERKER));
        http.exceptionHandling(
                handling -> handling.accessDeniedPage("/accessDenied.html"));
        return http.build();
    }
}