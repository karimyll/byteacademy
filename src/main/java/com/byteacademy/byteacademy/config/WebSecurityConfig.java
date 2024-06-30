package com.byteacademy.byteacademy.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.http.HttpMethod.*;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(permitSwagger).permitAll()
                                .requestMatchers("/api/v1/auth/login").permitAll()
                                .requestMatchers(GET,"/api/v1/applications/**").hasAnyRole(STAFF)
                                .requestMatchers(PUT,"/api/v1/applications/**").hasAnyRole(STAFF)
                                .requestMatchers(DELETE,"/api/v1/applications/**").hasAnyRole(STAFF)
                                .requestMatchers(POST,"/api/v1/applications").permitAll()
                                .requestMatchers(GET,"/api/v1/certificates").hasAnyRole(STAFF)
                                .requestMatchers(POST,"/api/v1/certificates").hasAnyRole(STAFF)
                                .requestMatchers(PUT,"/api/v1/certificates/**").hasAnyRole(STAFF)
                                .requestMatchers(DELETE,"/api/v1/certificates/**").hasAnyRole(STAFF)
                                .requestMatchers(GET,"/api/v1/certificates/no/**").permitAll()
                                .requestMatchers(GET,"/api/v1/courses/**").permitAll()
                                .requestMatchers(POST,"/api/v1/courses/**").hasAnyRole(STAFF)
                                .requestMatchers(PUT,"/api/v1/courses/**").hasAnyRole(STAFF)
                                .requestMatchers(DELETE,"/api/v1/courses/**").hasAnyRole(STAFF)
                                .requestMatchers("/api/v1/enrollments").hasAnyRole(STAFF)
                                .requestMatchers("/api/v1/groups").hasAnyRole(STAFF)
                                .requestMatchers("/api/v1/staff").hasAnyRole(STAFF)
                                .requestMatchers(POST,"/api/v1/students").hasAnyRole(STAFF)
                                .requestMatchers(GET,"/api/v1/students/**").hasAnyRole(STAFF)
                                .requestMatchers(PUT, "/api/v1/students/**").hasAnyRole("STUDENT", "STAFF", "ADMIN")
                                .requestMatchers(GET,"/api/v1/teachers/**").permitAll()
                                .requestMatchers(POST,"/api/v1/teachers").hasAnyRole(STAFF)
                                .requestMatchers(PUT,"/api/v1/teachers/**").hasAnyRole(STAFF)
                                .anyRequest().authenticated())
                .exceptionHandling(exceptionHandling -> exceptionHandling
                        .authenticationEntryPoint((request, response, authException) ->
                                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED)
                        )
                        .accessDeniedHandler((request, response, accessDeniedException) ->
                                response.setStatus(HttpServletResponse.SC_FORBIDDEN)
                        )
                );

        http.authenticationProvider(authenticationProvider);
        http.addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    public static String[] TEACHER = {
            "TEACHER",
            "ADMIN"
    };

    public static String[] STUDENT = {
            "STUDENT",
            "ADMIN"
    };

    public static String[] STAFF = {
            "STAFF",
            "ADMIN"
    };


    public static String[] permitSwagger = {
            "v3/api-docs/**",
            "v3/api-docs.yaml",
            "swagger-ui/**",
            "/swagger-ui.html"
    };
}
