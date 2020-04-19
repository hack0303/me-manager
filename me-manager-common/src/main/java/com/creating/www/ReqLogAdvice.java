package com.creating.www;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class ReqLogAdvice {

	@Pointcut(value = "@annotation(com.creating.www.ReqLog)")
	public void reqLogPointCut() {
		
	}
	@Around("reqLogPointCut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		long begin=System.currentTimeMillis();
		Object result=pjp.proceed();
		long end=System.currentTimeMillis();
		log.info("execution cost time [{}]ms",end-begin);
		return result;
		
	}
}
