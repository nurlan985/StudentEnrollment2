package edu.miu.cs.cs544.group1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import edu.miu.cs.cs544.group1.domain.security.Role;
import edu.miu.cs.cs544.group1.service.impl.UserDetailsServiceImpl;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{

	@Bean
	public UserDetailsService userDetailsService () {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
    };
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.httpBasic()
        	.and()
            .csrf().disable()
            .authorizeRequests()
            .antMatchers(HttpMethod.POST, "/sections/**").hasRole(Role.ROLEADMIN.toString())
            .antMatchers(HttpMethod.PUT, "/sections/**").hasRole(Role.ROLEADMIN.toString())
            .antMatchers(HttpMethod.DELETE, "/sections/**").hasRole(Role.ROLEADMIN.toString())
            .antMatchers(HttpMethod.GET, "/sections/**").hasAnyRole(Role.ROLEADMIN.toString(), Role.ROLEFACULTY.toString(), Role.ROLESTUDENT.toString())
            
            .antMatchers("/anonymous*").anonymous()// access=none
            .antMatchers("/login*").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginProcessingUrl("/login")
            .defaultSuccessUrl("/", true)
            .failureUrl("/login?error=true")
            .and()
            .logout()
            .logoutSuccessUrl("/login")
            .logoutUrl("/logout")
            .deleteCookies("JSESSIONID");
        http
        	.sessionManagement()
        	.maximumSessions(3)
        	.maxSessionsPreventsLogin(true)
        	.and()
        	.sessionFixation();
    }
}
