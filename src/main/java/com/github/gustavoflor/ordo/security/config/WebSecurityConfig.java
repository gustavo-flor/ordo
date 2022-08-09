package com.github.gustavoflor.ordo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {
    private static final String[] GET_AUTHORIZED_PATHS = {"/", "/health", "/swagger-ui/*", "/v3/api-docs", "/v3/api-docs/*"};
    private static final String[] POST_AUTHORIZED_PATHS = {};
    private static final String[] PUT_AUTHORIZED_PATHS = {};
    private static final String[] DELETE_AUTHORIZED_PATHS = {};
    private static final String[] PATCH_AUTHORIZED_PATHS = {};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .cors()
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.GET, GET_AUTHORIZED_PATHS)
            .permitAll()
            .antMatchers(HttpMethod.POST, POST_AUTHORIZED_PATHS)
            .permitAll()
            .antMatchers(HttpMethod.PUT, PUT_AUTHORIZED_PATHS)
            .permitAll()
            .antMatchers(HttpMethod.DELETE, DELETE_AUTHORIZED_PATHS)
            .permitAll()
            .antMatchers(HttpMethod.PATCH, PATCH_AUTHORIZED_PATHS)
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .csrf()
            .disable()
            .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
