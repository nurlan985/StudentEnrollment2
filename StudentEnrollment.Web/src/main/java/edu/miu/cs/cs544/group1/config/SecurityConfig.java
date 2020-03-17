package edu.miu.cs.cs544.group1.config;

import org.springframework.context.annotation.Bean;
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
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter 
{
//	@Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl();
//    }
//    @Bean
//    public BCryptPasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//    @Bean
//    public DaoAuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        authProvider.setUserDetailsService(userDetailsService());
//        authProvider.setPasswordEncoder(passwordEncoder());
//        return authProvider;
//    }
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) {
//        auth.authenticationProvider(authenticationProvider());
//    }
//    @Override
//    protected void configure(final HttpSecurity http) throws Exception {
////        http
////                .authorizeRequests()
////                .antMatchers("/wallPage")
////                .hasAnyRole(Role.ROLE_ADMIN.toString(), Role.ROLE_PROFESSOR.toString())
////                .and()
////                .authorizeRequests()
////                .antMatchers("/login", "/resource/**").permitAll()
////                .and()
////          .formLogin()
////          	.loginPage("/login")
////          		.usernameParameter("email")
////          		.passwordParameter("password").permitAll()
////                .loginProcessingUrl("/doLogin")
////                .successForwardUrl("/postLogin")
////                .failureUrl("/loginFailed")
////                .and()
////                .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll()
////                .and()
////                .csrf().disable();
//		   //   super.configure(http);
//		        http.httpBasic().and()
//                .csrf().disable()
//                .authorizeRequests()
//                //only for users with admin role : xlm= access="ROLE_ADMIN"
//                .antMatchers("/admin/**").hasAnyRole(Role.ROLE_ADMIN.toString())
//                .antMatchers("/faculty/**").hasAnyRole(Role.ROLE_PROFESSOR.toString())
//                .antMatchers("/student/**").hasAnyRole(Role.ROLE_STUDENT.toString())
//
//
//                // xml= access="IS_AUTHENTICATED_ANONYMOUSLY"
//                .antMatchers("/anonymous*").anonymous().// access=none
//                antMatchers("/login*").permitAll().anyRequest().authenticated()
//                .and()
//                .formLogin()
//
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/", true)
//                .failureUrl("/login?error=true")
//                //  .failureHandler(authenticationFailureHandler())
//                .and()
//                .logout().logoutSuccessUrl("/login")
//                .logoutUrl("/perform_logout")
//                .deleteCookies("JSESSIONID");
//        //   .logoutSuccessHandler(logoutSuccessHandler());
//        http.sessionManagement().maximumSessions(2).maxSessionsPreventsLogin(true).and().sessionFixation();
//    }
}
