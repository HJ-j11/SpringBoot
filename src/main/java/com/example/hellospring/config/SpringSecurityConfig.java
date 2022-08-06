package com.example.hellospring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.hellospring.security.UserRole.ADMIN;
import static com.example.hellospring.security.UserRole.USER;


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

//               .antMatchers("/user/**").hasRole("loginUser")
//               .and()
//               .formLogin()
//               .loginPage("/login").failureUrl("/errPage");
   }

    @Override
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("pwd"))
                .roles(USER.name())
                .build();

        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("pass"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                user,
                admin
        );
    }

}
