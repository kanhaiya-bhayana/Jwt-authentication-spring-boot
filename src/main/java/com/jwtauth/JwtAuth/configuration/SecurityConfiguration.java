package com.jwtauth.JwtAuth.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails adminUser = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN").build();
        UserDetails employeeuser = User.builder().username("smith").password(passwordEncoder().encode("smith")).roles("EMPLOYEE").build();


        return new InMemoryUserDetailsManager(adminUser, employeeuser);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers(HttpMethod.GET,"home/users").hasAnyRole("EMPLOYEE", "ADMIN")
                        .requestMatchers(HttpMethod.POST,"home/*").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"home/*").hasRole("ADMIN")
        );


        // use HTTP Basic authentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross-Request Site Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}
