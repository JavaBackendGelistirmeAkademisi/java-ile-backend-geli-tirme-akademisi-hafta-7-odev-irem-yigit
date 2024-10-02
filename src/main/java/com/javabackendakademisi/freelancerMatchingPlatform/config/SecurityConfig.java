package com.javabackendakademisi.freelancerMatchingPlatform.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()  // CSRF korumasını devre dışı bırakıyoruz
                .authorizeRequests()
                .anyRequest().permitAll();  // Tüm istekler serbest
        return http.build();
    }
}
