package org.binar.cinema.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}user123").roles("USER")
                .and()
                .withUser("admin").password("{noop}admin123").roles("ADMIN");
    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        HttpSecurity disable = http.httpBasic().and()
                .authorizeRequests()
                .antMatchers("/api/**").hasAnyRole("ADMIN").and()
                .csrf().disable()
                .formLogin().disable();
    }
}
