package com.example.przychodnia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.przychodnia.Service.UsersDetailsService;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/home").hasAnyRole("ADMIN","DOCTOR","RECEPTION")
			.antMatchers("/patient/**").hasAnyRole("ADMIN","RECEPTION")
			.antMatchers("/user/add").hasRole("ADMIN")
			.antMatchers("/user/visitForDoctor/**").hasAnyRole("ADMIN","RECEPTION")
			.antMatchers("/visit/today").hasAnyRole("ADMIN","DOCTOR","RECEPTION")
			.and().formLogin()
			.defaultSuccessUrl("/home")
			.and().logout().logoutSuccessUrl("/login")
            .permitAll()
            .and().exceptionHandling().accessDeniedPage("/404");
	}
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UsersDetailsService UsersDetailsService() {
        return new UsersDetailsService();
    }
}
