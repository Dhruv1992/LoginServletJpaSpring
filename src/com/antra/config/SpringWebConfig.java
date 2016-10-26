package com.antra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages="com.antra")
@Configuration

public class SpringWebConfig extends WebMvcConfigurerAdapter{

	@Bean
	public InternalResourceViewResolver getViewResolver(){
		InternalResourceViewResolver resourceView = new InternalResourceViewResolver();
		resourceView.setViewClass(JstlView.class);
		resourceView.setPrefix("/WEB-INF/views/");
		resourceView.setSuffix(".jsp");
		return resourceView;
	}
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
		configurer.enable();
	}
	
	@Bean
	public CommonsMultipartResolver multipartResolver(){
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSizePerFile(5*1024*1024);
	    multipartResolver.setResolveLazily(true);
	    return multipartResolver;
	}
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }
}
