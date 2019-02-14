package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


@Configuration
@ComponentScan("com.example.web")
@EnableWebMvc
public class WebConfig {

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Bean
	public BCryptPasswordEncoder bcp() {
		return new BCryptPasswordEncoder();
	}
	
	
//	@Bean
//	public ViewResolver viewResolver(SpringTemplateEngine templateEngine) {
//	ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//	viewResolver.setTemplateEngine(templateEngine);
//	return viewResolver;
//	}	
//	@Bean
//	public TemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
//	SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//	templateEngine.setTemplateResolver(templateResolver);
//	return templateEngine;
//	}
//	@Bean
//	public SpringResourceTemplateResolver templateResolver() {
//	SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//	templateResolver.setPrefix("/WEB-INF/templates/");
//	templateResolver.setSuffix(".html");
//	templateResolver.setTemplateMode("HTML5");
//	return templateResolver;
//	}
	
	
}
