package com.hemre.springboot.demoSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}password123")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}password123")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails susan = User.builder()
//                .username("susan")
//                .password("{noop}password123")
//                .roles("EMPLOYEE", "MANAGER", "ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary, susan);
//    }

    // add support for jdbc...no more hard coding
    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(datasource);

        //normally we were jsut returning new JdbcUserDetailsManager(datasource);
        // but if we have custom tables not a table for customized for spring we write custom sql queries

        //define query to retrieve a user by user_id on custom table
        jdbcUserDetailsManager.setUsersByUsernameQuery(
                "select user_id, pw, active from members where user_id=?"
        );
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "select user_id, role from roles where user_id=?"
        );
        //define query to retrieve a user by authorities on custom table

        return jdbcUserDetailsManager;

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(
                        configurer ->
                            configurer
                                    .requestMatchers("/").hasRole("EMPLOYEE")
                                    .requestMatchers("/leaders/**").hasRole("MANAGER")
                                    .requestMatchers("/systems/**").hasRole("ADMIN")
                                    .anyRequest().authenticated()
                )
                .exceptionHandling(
                        configurer ->
                            configurer
                                    .accessDeniedPage("/access-denied")

                )
                .formLogin(
                        form ->
                                form
                                        .loginPage("/showMyLoginPage")
                                        .loginProcessingUrl("/authenticateTheUser")
                                        .permitAll()
                )
                .logout(
                        logout -> logout.permitAll()
                );
        return http.build();
    }
}
