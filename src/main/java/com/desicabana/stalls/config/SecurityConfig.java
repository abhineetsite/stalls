package com.desicabana.stalls.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.desicabana.stalls.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /*
     * @Bean
     * public SecurityFilterChain securityFilterChain(HttpSecurity http) throws
     * Exception {
     * //http
     * // .csrf().disable()
     * // .authorizeRequests()
     * // .anyRequest().permitAll();
     * //return http.build();
     * http
     * .csrf(csrf -> csrf.disable())
     * .authorizeRequests(authorize -> authorize
     * .anyRequest().permitAll());
     * return http.build();
     * }
     */

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeRequests(authorize -> authorize
                        .anyRequest().authenticated())
                .formLogin()
                .loginPage("/employee/login")
                .defaultSuccessUrl("/employee/profile", true)
                .failureUrl("/employee/loginError") // Add this line
                .permitAll()
                .and() // Add this line to chain the logout() method
                .logout()
                .logoutSuccessUrl("/employee/login?logout") // Use logoutSuccessUrl() instead of logoutSuccessURL()
                .permitAll();
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    //--@Bean ??? Causing circular dependency between UserDetailsServiceImpl and SecurityConfig??
    /* @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    } */
}