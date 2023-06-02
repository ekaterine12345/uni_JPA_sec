package com.example.uni_jpa_sec.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
       http.csrf().disable()
               .authorizeHttpRequests((authorize) -> authorize.anyRequest().authenticated())
               .httpBasic(Customizer.withDefaults());

       return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails eka = User.builder()
                .username("eka")
                .password(passwordEncoder().encode("eka"))
                .roles("USER")
                .build();


        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin"))
                .roles("ADMIN")
                .build();

//        UserDetails user1 = User.withUsername("bb")
//                .password(passwordEncoder().encode("pwd"))
//                .roles("USER")
//                .build();


        return new InMemoryUserDetailsManager(eka, admin);
    }
}
