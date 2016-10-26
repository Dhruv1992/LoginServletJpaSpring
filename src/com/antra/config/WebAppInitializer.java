package com.antra.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(SpringJpaConfig.class);
		
        container.addListener(new ContextLoaderListener(rootContext));
        
		AnnotationConfigWebApplicationContext configContext = new AnnotationConfigWebApplicationContext();
		configContext.register(SpringWebConfig.class);
		configContext.setServletContext(container);
		
		Dynamic serv = container.addServlet("dispatcher", new DispatcherServlet(configContext));
		serv.setLoadOnStartup(1);
		serv.addMapping("/");
	}

}
