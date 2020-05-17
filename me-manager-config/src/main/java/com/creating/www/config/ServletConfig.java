package com.creating.www.config;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
	String health="{\"code\":200,\"message\":\"hello\",\"timestamp\":%d}";
	@Bean
	ServletRegistrationBean<Servlet> health() {
		return new ServletRegistrationBean<Servlet>(new Servlet() {
			
			@Override
			public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
				res.getWriter().write(String.format(health, System.currentTimeMillis()));
				res.getWriter().close();
				
			}
			
			@Override
			public void init(javax.servlet.ServletConfig config) throws ServletException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public String getServletInfo() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public javax.servlet.ServletConfig getServletConfig() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void destroy() {
				// TODO Auto-generated method stub
				
			}
		}, "/health");
	}
}
