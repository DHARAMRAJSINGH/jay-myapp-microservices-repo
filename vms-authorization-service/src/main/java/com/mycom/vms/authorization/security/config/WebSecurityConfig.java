package com.mycom.vms.authorization.security.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.RequestAttributeSecurityContextRepository;

import static org.springframework.security.config.Customizer.withDefaults;

/*@Configuration
@EnableWebSecurity*/
public class WebSecurityConfig {

    @Bean
    @Order(1)
    public SecurityFilterChain userLoginFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .antMatcher("/user/login")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                );
        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain adminPageFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .antMatcher("/admin/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasRole("ADMIN")
                )
                .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    @Order(3)
    public SecurityFilterChain usersPageFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .antMatcher("/users/**")
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().hasAnyRole("USER","ADMIN")
                )
                .httpBasic(withDefaults());
        return http.build();
    }
    @Bean
    @Order(SecurityProperties.BASIC_AUTH_ORDER)
    public SecurityFilterChain formLoginFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults())
                .formLogin(withDefaults());
        return http.build();
    }

}
