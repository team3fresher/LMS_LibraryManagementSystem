package com.team3.LMS.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**", "/index.html", "/login.html", "/partials/**", "/", "/error/**");
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
        http
            .authorizeRequests()
                .antMatchers("/").permitAll()
                /*.antMatchers("/index").permitAll()*/
                .antMatchers("/index").hasRole("MEMBER")
                
                .antMatchers("/book/list").permitAll()
                .antMatchers("/userInfo/add").permitAll()
                .antMatchers("/book/findAll/**").permitAll()
                .antMatchers("/book/get/**").permitAll()
                .antMatchers("/book/edit").hasRole("MEMBER")
                
                .antMatchers("/category/list").permitAll()
                .antMatchers("/category/findAll/**").permitAll()
                .antMatchers("/category/get/**").permitAll()

                .antMatchers("/author/list").permitAll()
                .antMatchers("/author/findAll/**").permitAll()
                .antMatchers("/author/get/**").permitAll()

                .antMatchers("/publisher/list").permitAll()
                .antMatchers("/publisher/findAll/**").permitAll()
                .antMatchers("/publisher/get/**").permitAll()
                
                //.antMatchers("/userInfo/**").hasRole("MEMBER")
                .antMatchers("/book/check/**").permitAll()
                
                .antMatchers("/ticket/add").hasRole("MEMBER")
                .antMatchers("/ticket/get/**").hasRole("MEMBER")
                
                .antMatchers("/book/**").hasRole("ADMIN")
                .antMatchers("/category/**").hasRole("ADMIN")
                .antMatchers("/author/**").hasRole("ADMIN")
                .antMatchers("/payment/**").hasRole("ADMIN")
                .antMatchers("/publisher/**").hasRole("ADMIN")
                .antMatchers("/returnBook/**").hasRole("ADMIN")
                .antMatchers("/ticket/**").hasRole("ADMIN")
                .antMatchers("/publisher/**").hasRole("ADMIN")
                .antMatchers("/returnBook/**").hasRole("ADMIN")
                .antMatchers("/admin").hasRole("ADMIN")
                .and()
            .formLogin()
            	.loginPage("/login")
            	.usernameParameter("email")
            	.passwordParameter("password")
            	.defaultSuccessUrl("/")
            	.failureUrl("/login?error")
            	.and()
        	.exceptionHandling()
    			.accessDeniedPage("/403");
    }
	
}
