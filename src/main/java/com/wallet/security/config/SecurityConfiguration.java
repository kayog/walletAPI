package com.wallet.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{ 
	
    @Override
    protected void configure(HttpSecurity http) throws Exception{
    	http.csrf().disable().exceptionHandling().and().sessionManagement()
    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
    	.antMatchers("**")
		.permitAll().anyRequest().authenticated();
    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//    	http.csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
//    	.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
//    	.antMatchers("/auth/**", "/configuration/security", "/webjars/**", "/user/**", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html", "/hello-world")
//		.permitAll().anyRequest().authenticated();
//		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//		http.headers().cacheControl();
//    }
}
