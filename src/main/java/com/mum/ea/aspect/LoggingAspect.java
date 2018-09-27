package com.mum.ea.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Yahia
 *
 */
@Aspect
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.mum.ea.service.*.*(..))")
	public void beforeServiceMethodsCall(JoinPoint joinpoint) {
		logger.info(new StringBuilder().append("Before calling method : ").append(joinpoint.getSignature().getName())
				.append(" in service layer").toString());
	}

	@After("execution(* com.mum.ea.service.*.*(..))")
	public void afterServiceMethodsCall(JoinPoint joinpoint) {
		logger.info(new StringBuilder().append("After calling method : ").append(joinpoint.getSignature().getName())
				.append(" in service layer").toString());
	}
}
