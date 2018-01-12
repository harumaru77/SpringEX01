package org.zerock.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SampleAdvice {
	private static final Logger logger = LoggerFactory.getLogger(SampleAdvice.class);
	
//	@Before("execution(* org.zerock.service.MessageService*.*(..))")
//	public void startLog(JoinPoint jp) {
//		// JoinPoint 타입 : 특정한 컨트롤러 호출시 전달되는 파라미터를 확인하기 위해서 사용되는 타입
//		
//		logger.info("-------------------------------------------");
//		logger.info("-------------------------------------------");
//		logger.info(Arrays.toString(jp.getArgs()));
//	}
//	
//	@Around("execution(* org.zerock.service.MessageService*.*(..))")
//	public Object timeLog(ProceedingJoinPoint pjp) throws Throwable{
//		long startTime = System.currentTimeMillis();
//		logger.info(Arrays.toString(pjp.getArgs()));
//		
//		Object result = pjp.proceed();	// 다음 Advice를 실행하거나, 실제 target 객체의 메소드를 실행하는 기능
//		
//		long endTime = System.currentTimeMillis();
//		logger.info(pjp.getSignature().getName() + " : " + (endTime - startTime));
//		logger.info("==========================================================");
//		
//		return result;
//	}
}
