package com.accolite.salescommission.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AOPs {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(AOPs.class);
	
	@Around("@annotation(LogCustom)")
	public Object loggingAdviceForRepository(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime =  System.currentTimeMillis();
		Object proceed = proceedingJoinPoint.proceed();
		long endTime = System.currentTimeMillis();
		logger.info("Time taken by method "+proceedingJoinPoint.getSignature().getName()+" is: "+ (endTime-startTime)+" ms");
		return proceed;
	}
	
//	@Around("execution(* com.accolite.salescommission.controller.SalesController.getSalesCommission(..))")
//	public Object loggingAdviceForRepository(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		long startTime =  System.currentTimeMillis();
//		Object proceed = proceedingJoinPoint.proceed();
//		long endTime = System.currentTimeMillis();
//		System.out.println("Time taken by method "+proceedingJoinPoint.getSignature().getName()+" is:"+ (endTime-startTime));
//		return proceed;
//	}
}
