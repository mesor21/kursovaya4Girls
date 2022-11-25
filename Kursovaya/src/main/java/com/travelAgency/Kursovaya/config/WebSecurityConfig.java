package com.travelAgency.Kursovaya.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;
    @Autowired
    UserDetailsService userSecice;
    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf()
                    .disable()
                .authorizeRequests()
                    .antMatchers("/","/signin","/login").permitAll()
                    .antMatchers("/signup").not().fullyAuthenticated()
                    .antMatchers("/admin/**").hasRole("admin")
                    .antMatchers("/client/**").hasRole("client")
                    .antMatchers("/dispatcher/**").hasRole("dispatcher")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/signin")
                        .permitAll()
                .and()
                    .logout()
                        .permitAll()
                        .logoutSuccessUrl("/");
    }
}
