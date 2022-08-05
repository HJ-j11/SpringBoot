package com.example.hellospring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SpringSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       http.authorizeRequests()
               .antMatchers("/","/list", "/css/*", "/js/*")
               .permitAll()
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();

//               .antMatchers("/css/**", "/").permitAll()
//               .antMatchers("/user/**").hasRole("loginUser")
//               .and()
//               .formLogin()
//               .loginPage("/login").failureUrl("/errPage");
   }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
               .withUser("user").password(passwordEncoder.encode("password")).roles("loginUser");
    }
}
