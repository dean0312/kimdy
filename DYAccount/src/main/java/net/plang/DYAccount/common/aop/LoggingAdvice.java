package net.plang.DYAccount.common.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoggingAdvice implements MethodInterceptor {
    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        String className = methodInvocation.getClass().getName();
        String methodName = methodInvocation.getMethod().getName();
        if(logger.isDebugEnabled())
            logger.debug(className + " : " + methodName + " Start");

        Object result = methodInvocation.proceed();

        if(logger.isDebugEnabled())
            logger.debug(className + " : " + methodName + " End");
        
        return result;
    }
}
