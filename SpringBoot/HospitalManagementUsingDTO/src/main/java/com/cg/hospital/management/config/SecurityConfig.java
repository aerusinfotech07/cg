package com.cg.hospital.management.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("doctor")
                .password(passwordEncoder.encode("password"))
                .roles("DOCTOR")
                .build());
        manager.createUser(User.withUsername("patient")
                .password(passwordEncoder.encode("password"))
                .roles("PATIENT")
                .build());
        manager.createUser(User.withUsername("admin")
                .password(passwordEncoder.encode("password"))
                .roles("ADMIN")
                .build());
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
        		// Require ADMIN role for POST and PUT requests to /api/admin/**
                .requestMatchers(HttpMethod.POST, "/api/admin/**").hasRole("ADMIN")
                .requestMatchers(HttpMethod.PUT, "/api/admin/**").hasRole("ADMIN")                    
                // Allow all other HTTP methods on /api/admin/** without ADMIN role
                .requestMatchers("/api/admin/**").permitAll()
                .requestMatchers("/api/doctor/**").hasAnyRole("DOCTOR","ADMIN")
                .requestMatchers("/api/patient/**").hasRole("PATIENT")
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults()) // Enable basic authentication using withDefaults()
            .csrf(csrf -> csrf.disable()); // Disable CSRF (can also use .csrf(csrf -> csrf.disable()) if you need to disable it entirely

        return http.build();
    }
}
