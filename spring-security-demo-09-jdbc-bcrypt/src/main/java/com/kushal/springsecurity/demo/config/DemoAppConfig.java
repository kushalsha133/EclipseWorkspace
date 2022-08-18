package com.kushal.springsecurity.demo.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.kushal.springsecurity.demo")
@PropertySource("classpath:persistence-mysql.properties")
public class DemoAppConfig {
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	//setting up variable to hold the properties
	@Autowired
	private Environment env;
	
	private Logger logger = Logger.getLogger(getClass().getName());;
	
	//defining a bean for datasource
	@Bean
	public DataSource securityDataSource() {
		//Create Connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();
		
		//System.out.println("\nOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO"+env.getProperty("jdbc.driver")+"\n"+env.getProperty("jdbc.url"));
		//set up jdbc driver
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		//log the connection props
		logger.info("JDBC URL :"+env.getProperty("jdbc.url"));
		logger.info("UserName: "+env.getProperty("jdbc.user"));
		
		//set up the database connetion
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));
		//set up the connection pool props
		securityDataSource.setInitialPoolSize(getInt("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getInt("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getInt("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getInt("connection.pool.maxIdleTime"));
		
		return securityDataSource;
	}
	
	private int getInt(String propName) {
		String propVal = env.getProperty(propName);
		return Integer.parseInt(propVal);
	}
}
