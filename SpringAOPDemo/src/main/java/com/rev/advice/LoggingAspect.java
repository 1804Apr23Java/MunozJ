package com.rev.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component(value="loggingAspect")
public class LoggingAspect {
	
	//could be configured as bean
	private static Logger log = Logger.getRootLogger();
	
	@AfterReturning(pointcut="within(com.revature.service.*)")
	public void logAfterReturn(JoinPoint jp) {
		log.info(jp.getSignature());
	}
	
	@AfterThrowing("within(*)")
	public void logAfterThrow(JoinPoint jp) {
		log.error(jp.getSignature());
	}
}