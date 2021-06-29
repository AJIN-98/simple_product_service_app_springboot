package com.ust.Aspectj;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {
	
	
	
	private static final Log log = LogFactory.getLog(LoggingAspect.class);

	@Before("execution(* com.ust.controller.productController.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		log.info("before called.... " + joinPoint.getSignature().getName());
	}

	@After("execution (* com.ust.controller.productController.*(..))")
	public void logAfter(JoinPoint joinPoint) {
		log.info("after called.... " + joinPoint.getSignature().getName());
	}

	@AfterReturning("execution (* com.ust.controller.productController.*(..))")
	public void logAfterReturning(JoinPoint joinPoint) {
		log.info("after returning called.... " + joinPoint.getSignature().getName());
	}

	@AfterThrowing("execution (* com.ust.controller.productController.*(..))")
	public void logAfterThrowing(JoinPoint joinPoint) {
		log.info("after throwing called.... " + joinPoint.getSignature().getName());
	}
	
	
	
	

}