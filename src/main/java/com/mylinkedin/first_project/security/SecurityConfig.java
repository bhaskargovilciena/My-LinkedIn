package com.mylinkedin.first_project.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        // we are setting custom security filter chain and hence, by default methods wont work
        httpSecurity
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/post/all").permitAll()
                        .requestMatchers("/company/all").permitAll()
                        .requestMatchers("/user/all").hasRole("ADMIN")
                        // hasAnyRole() for multiple roles
                        .anyRequest().authenticated())
                .formLogin(Customizer.withDefaults()); // giving by defaults config params to http security object
        return httpSecurity.build();
    }

    // @Bean commented so that custom service can be implemented
    UserDetailsService userDetailsService() {
        PasswordEncoder passwordEncoder = passwordEncoder();
        UserDetails user1 = User.withUsername("bhaskar")
                .password(passwordEncoder.encode("bhaskar@1"))
                .roles("ADMIN")
                .build();

        UserDetails user2 = User.withUsername("demoUser")
                .password(passwordEncoder.encode("demouser"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user1, user2); // multiple users can be passed as params here
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager (AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}
