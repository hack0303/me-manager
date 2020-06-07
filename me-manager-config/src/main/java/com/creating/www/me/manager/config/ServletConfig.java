package com.creating.www.me.manager.config;

import com.creating.www.me.manager.common.pojos.HealthInfo;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import javax.annotation.PostConstruct;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class ServletConfig {
	String health="{\"code\":200,\"message\":\"hello\",\"timestamp\":%d}";
        private static ObjectMapper objectMapper=new ObjectMapper();
        static long started=System.currentTimeMillis();
        static long pid=0;
        @PostConstruct
        void init(){
            RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();
                               log.info("pid is:{}",runtimeMXBean.getPid());
        }
	@Bean
	ServletRegistrationBean<Servlet> health() {
		return new ServletRegistrationBean<Servlet>(new Servlet() {
			
			@Override
			public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
                                
				//res.getWriter().write(String.format(health, System.currentTimeMillis()));
                                HealthInfo pojo=new HealthInfo();
                                pojo.setStatus(200);
                                pojo.setMessage("success");
                                pojo.setTimestamp(System.currentTimeMillis());
                                pojo.setStarted(started);
				res.getWriter().write(objectMapper.writeValueAsString(pojo));
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
