package com.mycom.vms.authorization.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

@EnableWebSecurity
@Configuration
public class WebMvcSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
        http.csrf().disable();
        http
                .authorizeHttpRequests(
                        authorize -> authorize
                                .mvcMatchers("/auth/login").permitAll()
                                .mvcMatchers("/auth/test").permitAll()
                                .mvcMatchers("/admin/**").hasRole("ADMIN")
                                .mvcMatchers("/users/**").hasAnyRole("ADMIN", "USER")
                                .anyRequest().denyAll()
                );
        http.securityContext(securityContext -> securityContext
                .securityContextRepository(new HttpSessionSecurityContextRepository()));


        return http.build();
    }

}
