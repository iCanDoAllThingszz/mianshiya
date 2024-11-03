package com.yu.aop;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

/**
 * @Author:zhoayu
 * @Date:2024/11/3 21:26
 * @Description: 日志打印切面
 * @version:1.0
 */
@Aspect
@Slf4j
@Component
public class LogInterceptor {

    @Around("execution(* com.yu.controller.*.*(..))")
    public Object doInterceptor(ProceedingJoinPoint joinPoint) throws Throwable {
        // 计时
        StopWatch stopwatch = new StopWatch();
        stopwatch.start();
        // 获取请求接口路径
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 生成请求唯一id
        String requestId = UUID.randomUUID().toString();
        String uri = httpServletRequest.getRequestURI();
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        String reqParam = "[" + StringUtils.join(args, ", ") + "]";

        // 输出请求日志
        log.info("request start，id: {}, path: {}, ip: {}, params: {}", requestId, uri,
                httpServletRequest.getRemoteHost(), reqParam);

        // 执行原方法
        Object result = joinPoint.proceed();
        // 输出响应日志
        stopwatch.stop();
        long totalTimeMillis = stopwatch.getTotalTimeMillis();
        log.info("request end, id: {}, cost: {}ms", requestId, totalTimeMillis);
        return result;
    }
}
