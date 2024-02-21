package soft.pegas.vocabularychieftain.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request ->
                request
                        .requestMatchers(HttpMethod.GET, "/learning-resources/all").permitAll()
                        .anyRequest().authenticated()
        );

        return http.build();
    }
}
