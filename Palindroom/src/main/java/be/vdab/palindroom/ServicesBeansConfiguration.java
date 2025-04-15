package be.vdab.palindroom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesBeansConfiguration {

    @Bean
    WoordService woordService() {
        return new WoordService();
    }
}
