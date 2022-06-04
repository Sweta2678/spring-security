package com.codeoart.springsecuritybasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * 
 * @author sweta.khatsuriya
 *
 */
@SpringBootApplication
//@ComponentScan("com.codeoart.controller")
@ComponentScans({@ComponentScan("com.codeoart.controller"),@ComponentScan("com.codeoart.config")})
@EnableJpaRepositories("com.codeoart.repository")
@EntityScan("com.codeoart.model")
@EnableWebSecurity(debug = true)
public class SpringSecurityBasicApplication {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBasicApplication.class, args);
	}

}
