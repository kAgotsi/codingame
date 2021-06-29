package com.atos.airfrance.codingame.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.UUID;

/**
 * <pre>
 * Title: LoggingAspect class
 * Description: Aspect definition class for logging
 * </pre>
 *
 * @author Gédéon AGOTSI
 * @version 1.0
 */
@Aspect
@Component
public class LoggingAspect {

   private final static Logger log = LoggerFactory.getLogger(LoggingAspect.class);

    /**
     * Get informations and log about jonction point
     * @param joinPoint the proceeding join point, a must because we need to call ProceedingJoinPoint.proceed() to execute the annotated method
     * @return generic object
     * @throws Throwable Throwable if something goes wrong
     */
    @Around("execution(* com.atos.airfrance.codingame.controllers..*(..))")
    public Object profileExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        final long start = System.currentTimeMillis();
        final String className = joinPoint.getSignature().getDeclaringTypeName();
        final String methodName = joinPoint.getSignature().getName();
        final String apiName = className + "."+ methodName;

        HttpServletRequest request =
                ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        final String requestId = UUID.randomUUID().toString();
        log.info("\nREQUESTED_ID: {}\nHOST: {} HttpMethod: {}\nURI: {}\nAPI METHOD: {}\nArguments(Inputs): {}\n",
                requestId,
                request.getHeader("host"),
                request.getMethod(),
                request.getRequestURI(),
                apiName,
                Arrays.toString(joinPoint.getArgs()));

        Object result = joinPoint.proceed();
        final long elapsedTime = System.currentTimeMillis() - start;
        log.info("\nExecution Time: {} ms [REQUESTED_ID: {}] [API: {}] \n [RESPONSE(OUTPUT): {}]", elapsedTime,requestId,apiName,result);
        return result;
    }

    /**
     * Get informations and log after throwing advice
     * @param joinPoint the proceeding join point, a must because we need to call ProceedingJoinPoint.proceed() to execute the annotated method
     * @param ex exception
     */
    @AfterThrowing(value="execution(* com.atos.airfrance.codingame.services..*(..))",throwing="ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex)
    {
        log.info("\nException when executing method : {} \ndetails :   {}", joinPoint.getSignature(),ex.getMessage());
    }
}