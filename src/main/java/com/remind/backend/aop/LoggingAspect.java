package com.remind.backend.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.Optional;


@Aspect
@Component
@Slf4j
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    @Around("@annotation(org.springframework.web.bind.annotation.ExceptionHandler)")
    public Object logExceptionHandler(ProceedingJoinPoint joinPoint) throws Throwable{
        Object[] args = joinPoint.getArgs();

        Optional<HttpServletRequest> requestOpt = Arrays.stream(args)
                .filter(arg -> arg instanceof HttpServletRequest)
                .map(arg -> (HttpServletRequest) arg)
                .findFirst();

        Optional<Exception> exceptionOpt = Arrays.stream(args)
                .filter(arg -> arg instanceof Exception)
                .map(arg -> (Exception) arg)
                .findFirst();

        requestOpt.ifPresent(request ->
                exceptionOpt.ifPresent(exception ->
                        log.error("Exception occurred on URL {}: {}",
                                request.getRequestURL(),
                                exception.getMessage(),
                                exception)
                    )
                );

        return joinPoint.proceed();
    }
}
