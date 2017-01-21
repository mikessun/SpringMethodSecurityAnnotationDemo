package com.websystique.springsecurity.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.websystique.springsecurity")
public class HelloWorldConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver viewResolver() {
		ContentNegotiatingViewResolver contentNegotiatingViewResolver=new ContentNegotiatingViewResolver();
		List list=new ArrayList();
		list.add(new MappingJackson2JsonView());
		contentNegotiatingViewResolver.setDefaultViews(list);
		return contentNegotiatingViewResolver;
	}
}