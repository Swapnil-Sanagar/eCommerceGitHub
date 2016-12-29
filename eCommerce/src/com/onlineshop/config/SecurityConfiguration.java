package com.onlineshop.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    CustomSuccessHandler customSuccessHandler;
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;
	
	@Bean(name = "bCryptPasswordEncoder")
	public BCryptPasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean(name="authenticationManager")
    public AuthenticationManager authenticationManagerBean() throws Exception {
       return super.authenticationManagerBean();
    }
	
	@Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
       /* auth.inMemoryAuthentication().withUser("swapnil.sangar@rediffmail.com").password("123456").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("root123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("root123").roles("ADMIN","DBA");*/
        /*auth.jdbcAuthentication().dataSource(dataSource)
		.usersByUsernameQuery(
			"select email,first_name,last_name,password from users where email=?")
		.authoritiesByUsernameQuery(
			"select users.email,users.first_name,users.last_name,role.name from user_role "+
			"join users ON users.user_id = user_role.user_id "+
			"join role ON role.id = user_role.role_id "+
			"where users.email=?");	*/
        
		auth.jdbcAuthentication().dataSource(dataSource)
		.passwordEncoder(passwordencoder())
		.usersByUsernameQuery("select user_name username,password,enabled from users where user_name=?")
		.authoritiesByUsernameQuery("select b.user_name username, a.role from user_roles a, users b where b.user_name=? and a.user_id=b.user_id");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
      /*http.authorizeRequests()
       // .antMatchers("/", "/home").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
        .antMatchers("/db/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_DBA')")
        .and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
        .usernameParameter("ssoId").passwordParameter("password")
        .and().exceptionHandling().accessDeniedPage("/Access_Denied")
        .and().csrf();*/
      
      http.authorizeRequests()
      .antMatchers("/addShippingAddress.htm").access("hasRole('ROLE_USER')")
      .antMatchers("/getAddressInfo.htm").access("hasRole('ROLE_USER')")
		.and()
			.formLogin().loginPage("/login")
			.defaultSuccessUrl("/loginSuccess")
			.failureUrl("/login?error")
			.usernameParameter("user_name").passwordParameter("password")				
		.and()
			.logout().logoutSuccessUrl("/logout");
    }
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordencoder());
        return authenticationProvider;
    }
}
