package com.greatlearning.studentmgmtsys.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.greatlearning.studentmgmtsys.serviceImpl.UserDetailsServiceImpl;

@Configuration

public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/student/save", "/student/showFormForAdd", "/student/403")
				.hasAnyAuthority("admin", "user").antMatchers("/student/showFormForUpdate/**", "/student/delete/**")
				.hasAuthority("admin").anyRequest().authenticated().and().formLogin().loginProcessingUrl("/login")
				.defaultSuccessUrl("/student/list").permitAll().and().logout().logoutSuccessUrl("/login").permitAll()
				.and().exceptionHandling().accessDeniedPage("/student/403").and().cors().and().csrf().disable();
	}
}
