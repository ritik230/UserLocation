package com.example.User_Location.configue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, "/get_userLocation").hasAnyRole("ADMIN","READER")
                .antMatchers(HttpMethod.POST, "/create_userLocation").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/update_userLocation/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.PATCH, "/patch_userLocation/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/delete_userLocation/**").hasRole("ADMIN")
                .and().httpBasic();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin123").roles("ADMIN")
                .and().withUser("reader1").password("{noop}reader123").roles("READER")
                .and().withUser("reader2").password("{noop}reader456").roles("READER");
    }

}
