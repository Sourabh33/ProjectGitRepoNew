package com.project.springmvc.configuration;
/* It is a replacement of  spring - servlet.xml */


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration /*  This marks this class 
				*  as configuration class as 
				*  mentioned above */

@EnableWebMvc /* This is equivalent to
 			   * mvc:annotation-driven in XML.
 			   */
@ComponentScan(basePackages = "com.project.springmvc")/*  ComponentScan refers to package 
													   * locations to find the associated 
													   * beans.*/
public class AppConfig {
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	/* This viewResolver Method will going to  
	 * resolve the views
	 * It configures a view resolver to identify the real view. 
	 */
	
	@Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }
	/* This messageSource method will send the server 
	 * side validation messages to 
	 * the client side for form validation 
	 * in case client side validation failed
	 * Spring will search for a file named messages.properties 
	 * in application class path.
	 */
}
