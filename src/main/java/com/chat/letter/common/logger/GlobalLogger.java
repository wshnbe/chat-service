package com.chat.letter.common.logger;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 全局日志拦截，拦截方法入参数据和返回数据
 */
@Aspect
@Component
public class GlobalLogger {

    private Logger logger = LoggerFactory.getLogger(GlobalLogger.class);

    @Pointcut("execution(* com.chat.letter.controller.*.*(..))")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint point){
        Object[] args = point.getArgs();
        Signature signature = point.getSignature();
        String typeName = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        logger.info("["+typeName+"."+methodName+"]请求参数{}", JSON.toJSONString(args[0]));
    }

    @AfterReturning(returning = "ret",pointcut = "pointCut()")
    public void afterReturn(JoinPoint point,Object ret){
        Signature signature = point.getSignature();
        String typeName = signature.getDeclaringTypeName();
        String methodName = signature.getName();
        logger.info("["+typeName+"."+methodName+"]返回结果：{}", JSON.toJSONString(ret));
    }
}
