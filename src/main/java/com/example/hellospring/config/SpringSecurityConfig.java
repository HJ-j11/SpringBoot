package com.example.hellospring.config;

import com.example.hellospring.security.ApplicationPermission;
import com.example.hellospring.security.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.example.hellospring.security.UserRole.*;


@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;

    public SpringSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
               .csrf().disable()
               .authorizeRequests()
               .antMatchers("/","/list", "/css/*", "/js/*").permitAll()
               .antMatchers("/api/**").hasRole(USER.name())
               .antMatchers(HttpMethod.DELETE, "/manage/api/**").hasAuthority(ApplicationPermission.COURSE_WRITE.getPermission())
               .antMatchers(HttpMethod.POST, "/manage/api/**").hasAuthority(ApplicationPermission.COURSE_WRITE.getPermission())
               .antMatchers(HttpMethod.PUT, "/manage/api/**").hasAuthority(ApplicationPermission.COURSE_WRITE.getPermission())
               .antMatchers(HttpMethod.GET, "/manage/api/**").hasAnyRole(ADMIN.name(), ADMINTRAIN.name())
               .anyRequest()
               .authenticated()
               .and()
               .httpBasic();
   }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
                .username("Kim")
                .password(passwordEncoder.encode("password"))
//                .roles(USER.name())
                .authorities(USER.getGrantedAuthorities())
                .build();

        UserDetails admin = User.builder()
                .username("Lee")
                .password(passwordEncoder.encode("password123"))
//                .roles(ADMIN.name())
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails trainee = User.builder()
                .username("Park")
                .password(passwordEncoder.encode("password456"))
//                .roles(ADMINTRAIN.name())
                .authorities(ADMINTRAIN.getGrantedAuthorities())
                .build();

        return new InMemoryUserDetailsManager(
                user,
                admin,
                trainee
        );
    }

}
