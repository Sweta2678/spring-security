package com.codeoart.config;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println(
				"Using default configure(HttpSecurity).If subclassed this will potentially override subclass configure(HttpSecurity).");
		/*
		 * default authentication
		 * 
		 * http.authorizeRequests((requests) -> requests.anyRequest().authenticated());
		 * http.formLogin(); http.httpBasic();
		 */

		// Authentication based on our requirement.

		http.cors().configurationSource(new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration configuration = new CorsConfiguration();
				configuration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
				configuration.setAllowedMethods(Collections.singletonList("*"));
				configuration.setAllowCredentials(true);
				configuration.setAllowedHeaders(Collections.singletonList("*"));
				configuration.setMaxAge(3600L);
				return configuration;
			}
		}).and().csrf().ignoringAntMatchers("/contact").csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()).and().
		authorizeRequests().antMatchers("/myAccount").authenticated().antMatchers("/myBalance").authenticated()
		.antMatchers("/myLoans").authenticated().antMatchers("/myCards").authenticated()
		.antMatchers("/user").authenticated().antMatchers("/notices").permitAll()
		.antMatchers("/contact").permitAll().and().httpBasic();
		
//		http.authorizeRequests((requests) -> requests.antMatchers("/myAccount").authenticated());
//		http.authorizeRequests((requests) -> requests.antMatchers("/myCards").authenticated());
//		http.authorizeRequests((requests) -> requests.antMatchers("/myLoans").authenticated());
//		http.authorizeRequests((requests) -> requests.antMatchers("/balance").authenticated());
//		http.authorizeRequests((requests) -> requests.antMatchers("/notices").permitAll());
//		http.authorizeRequests((requests) -> requests.antMatchers("/contact").permitAll());
//		http.formLogin();
//		http.httpBasic();

		// deny all the requests::
		// http.authorizeRequests((requests) ->
		// requests.anyRequest().denyAll()).formLogin().and().httpBasic();

	}

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * auth.inMemoryAuthentication().withUser("admin").password("admin123").
	 * authorities("admin").and().withUser("user")
	 * .password("user123").authorities("read").and().passwordEncoder(
	 * NoOpPasswordEncoder.getInstance()); }
	 */

	// same thing achived by inMemoryUserdetailmanager

	/*
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception { InMemoryUserDetailsManager userDetailServie = new
	 * InMemoryUserDetailsManager(); UserDetails user =
	 * User.withUsername("admin").password("admin123").authorities("admin").build();
	 * UserDetails user1 =
	 * User.withUsername("user").password("user123").authorities("read").build();
	 * userDetailServie.createUser(user); userDetailServie.createUser(user1);
	 * auth.userDetailsService(userDetailServie); }
	 */

	//via default JDBC implementation - JdbcUserDetailsManager
//	@Bean
//	public UserDetailsService userDetails(DataSource dataSource) {
//		return new JdbcUserDetailsManager(dataSource);
//	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
		//SCryptPasswordEncoder();
	}
}
