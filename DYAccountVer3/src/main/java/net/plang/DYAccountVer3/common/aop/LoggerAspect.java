package net.plang.DYAccountVer3.common.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
@Component
@Aspect
@Slf4j  //@Slf4j 를 써주면, log를 쓸 수 있다. 이것도 롬복 어노테이션 임.  	//import org.slf4j.Logger; //import org.slf4j.LoggerFactory; 이걸 대신해준다.
@Configuration
public class LoggerAspect {
	  //Logger log = LoggerFactory.getLogger(getClass());  //@Slf4j 어노테이션을 사용하면 로거를 따로 이렇게 생성할 필요가 없음.
	
	@Around("execution(* net.plang.DYAccountVer3..serviceFacade.*.*(..)) or execution(* net.plang.DYAccountVer3..applicationService.*.*(..)) or execution(* net.plang.DYAccountVer3..dao.*.*(..))")
	public Object logPrint(ProceedingJoinPoint joinPoint) throws Throwable {
		String type = "";
		String name = joinPoint.getSignature().getDeclaringTypeName();
		if (name.indexOf("Controller") > -1) {
			type = "Controller  \t:  ";
		}
		else if (name.indexOf("Service") > -1) {
			type = "ServiceImpl  \t:  ";
		}
		else if (name.indexOf("Mapper") > -1) {
			type = "Mapper  \t\t:  ";
		}
		log.warn(type + name + "." + joinPoint.getSignature().getName() + "()");   //디버그일 때 출력해줌.
		Object obj = joinPoint.proceed();
		
		return obj;
	}
	
}

