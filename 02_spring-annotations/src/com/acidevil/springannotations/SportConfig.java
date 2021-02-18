package com.acidevil.springannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.acidevil.springannotations")
@PropertySource("classpath:sport.properties")
/**
 * this class does not use .xml file to configure the spring application
 * 
 * @author Andrea
 *
 */
public class SportConfig {

	// define beans for use in other classes, note that the class
	// DatabaseFortuneService IS NOT a component, but it will be wrapped by a spring
	// bean
	@Bean
	public FortuneService databaseFortuneService() {
		return new DatabaseFortuneService();
	}
}
