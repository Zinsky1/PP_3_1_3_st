package com.example.fel.config;

import com.example.fel.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SpringConfig extends WebSecurityConfigurerAdapter {

    private final UserServiceImp userServiceImp;
    private final SuccessUserHandler successUserHandler;


    @Autowired
    public SpringConfig(UserServiceImp userService, SuccessUserHandler successUserHandler) {
        this.successUserHandler = successUserHandler;
        this.userServiceImp = userService;

    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")//.hasAuthority("ROLE_ADMIN")//.hasRole("ADMIN")
                    //.antMatchers("/user/**").hasRole("USER")
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .successHandler(successUserHandler)
                .and()
                    .logout().permitAll().logoutSuccessUrl("/");
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider =  new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userServiceImp);
        return daoAuthenticationProvider;
    }
}
