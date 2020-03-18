package edu.miu.cs.cs544.group1.service.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceAdvice {
    private static final Logger log = LogManager.getLogger(TraceAdvice.class);
    @Before("execution(* edu.miu.cs.cs544.group1.service.impl.*.*(..))")
	public void traceServiceMethods(JoinPoint joinPoint) {
		String logstring = "Class = " + joinPoint.getTarget().getClass().getSimpleName()
				+". Calling method = " + joinPoint.getSignature().getName();
		log.info(logstring);
	}
}
