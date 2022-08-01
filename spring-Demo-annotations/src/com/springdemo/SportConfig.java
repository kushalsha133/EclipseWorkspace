package com.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.springdemo")  //commenting this out as we only want the below mentioned two beans not all beans needs
//to be scanned
@PropertySource("classpath:sport.properties")
public class SportConfig {
	// definebean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	//idhar jo function name hoga that will be bean name in getBean()
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}
}
