
package com.pineapple.demo.models.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    
    protected void configure(HttpSecurity http)throws Exception{
       http
               .authorizeRequests()
               .antMatchers("/css/*")//agregar recursos para que accedan todos css,img.etc
               .permitAll()
               .antMatchers("/**").permitAll()
               .and()
               .formLogin()
               .loginPage("/login").permitAll();
    }
}
