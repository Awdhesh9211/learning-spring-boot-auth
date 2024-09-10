package com.alone.config;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .csrfTokenRepository(csrfTokenRepository()) // Configure CSRF Token Repository
            )
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/info").permitAll() // Allow access to /info without authentication
                .anyRequest().authenticated() // Require authentication for all other requests
            )
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults()); // Use default form login configuration

        return http.build();
    }

    @Bean
    public CsrfTokenRepository csrfTokenRepository() {
        return new HttpSessionCsrfTokenRepository(); // Use session-based CSRF token repository
    }
}
