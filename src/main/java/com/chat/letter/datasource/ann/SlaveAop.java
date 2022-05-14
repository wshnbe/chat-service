package com.chat.letter.datasource.ann;

import com.chat.letter.datasource.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class SlaveAop {

    @Pointcut("@annotation(com.chat.letter.datasource.ann.Slave)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint point){
        DataSourceHolder.setSlave();
    }

    @After("pointCut()")
    public void after(){
        DataSourceHolder.removeDataSource();
    }
}
