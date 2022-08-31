package com.example.webproject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        //Link mà người đại diện gõ trên trình duyệt
        http.authorizeRequests().antMatchers("/", "/product/**", "/register/**").permitAll()
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login/").permitAll()
                .defaultSuccessUrl("/login?success=true")
                .failureUrl("/login?success=fail")
                .usernameParameter("phone")
                .passwordParameter("pwd")
                .loginProcessingUrl("/j_spring_security_check");

        http.logout()
                .logoutUrl("/logout/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        /**
         *
         * <b>Đăng nhập áp dụng cho trường hợp tĩnh</b>
         *
         * auth.inMemoryAuthentication()
         *                 .withUser("chu").password(passwordEncoder().encode("123"))
         *                 .authorities("ROLE_USER");
         */

        /**
         * <b>Đăng nhập áp dụng cho trường hợp động</b>
         */

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }

}
