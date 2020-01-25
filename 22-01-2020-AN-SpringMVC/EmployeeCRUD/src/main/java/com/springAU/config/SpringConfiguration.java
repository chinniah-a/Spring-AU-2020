package com.springAU.config;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.springAU.dao.EmployeeDAO;
import com.springAU.dao.EmployeeDAOImpl;

//Configuration file for the application
@Configuration
@ComponentScan(basePackages="com.*")
@EnableWebMvc
@PropertySource("classpath:application.properties") //fetch data from application.properties
public class SpringConfiguration extends WebMvcConfigurerAdapter {
	
	@Autowired
	Environment environment;
	
	@Bean
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver(); //initialize web resolver
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) { //Add resource handlers
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
	
	 public DataSource getDataSource() {  //Initialize the datasource using data obtained from application.properties
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName(environment.getProperty("database.driver"));
	        dataSource.setUrl(environment.getProperty("database.url"));
	        dataSource.setUsername(environment.getProperty("database.user"));
	        dataSource.setPassword(environment.getProperty("database.password"));
	        
	         
	        return dataSource;
	    }
	 
	 
	 @Bean
	 public EmployeeDAO getEmployeeDAO() { //return datasource
		 System.out.println("Setting Up Database");
		 return new EmployeeDAOImpl(getDataSource());
	 }

}
