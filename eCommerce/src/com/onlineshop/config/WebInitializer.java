package com.onlineshop.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {
	@Override
	public void onStartup(ServletContext servletContext)
			throws ServletException {

		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);
		ctx.setServletContext(servletContext);
		servletContext.addListener(new ContextLoaderListener(ctx));
		Dynamic dispatcherServlet = servletContext.addServlet("dispatcher",
				new DispatcherServlet(ctx));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}
}