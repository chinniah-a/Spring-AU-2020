package com.springAU.aop.aspect;

import java.time.Duration;
import java.time.LocalTime;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	LocalTime start;
	LocalTime finish;
	
	@Before("execution(* com.springAU.aop.service.EmployeeManager.getAllEmployees(..))")
	public void logBeforeV1(JoinPoint joinPoint) {
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:ms");
		start = LocalTime.now();
		
		System.out.println("*******************************************");
		System.out.println("EmployeeAspect: joinBeforeV1 : " + joinPoint.getSignature().getName() + " Started execition at at: " + start); //Before Starting Execution
		System.out.println("*******************************************");
	}
	
	
	@After("execution(* com.springAU.aop.service.EmployeeManager.getAllEmployees())")
	public void logAfterV1(JoinPoint joinPoint) {
		//DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss:ms");  
		finish = LocalTime.now();
		System.out.println("*******************************************");
		System.out.println("EmployeeAspect: joinBeforeV1 : " + joinPoint.getSignature().getName() + " Successfully executed at: " +finish); //After Finishing Execution
		
		
		System.out.println("Execution Duration: " + Duration.between(start, finish).toNanos() + " Nanoseconds"); //Calculate Execution Time
		System.out.println("*******************************************");
	}
	
	
	
	
	
}
