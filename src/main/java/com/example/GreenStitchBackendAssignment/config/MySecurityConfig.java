package com.example.GreenStitchBackendAssignment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.example.GreenStitchBackendAssignment.service.CustomUserLoginService;

@Configuration
public class MySecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder();
    }
    

    @Bean
        public SecurityFilterChain configure(HttpSecurity httpSecurity)throws Exception {
        httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/register").permitAll()
        .requestMatchers("/hello").hasAnyAuthority("USER")
        .anyRequest().authenticated().
        and().formLogin();

        return httpSecurity.build();
        }

    @Bean
        public AuthenticationManager getAuthenticationManager(UserDetailsService userDetailsService,
                        PasswordEncoder passwordEncoder, HttpSecurity httpSecurity) throws Exception {
                AuthenticationManagerBuilder builder = httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
                builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
                return builder.build();
        }

        
}
