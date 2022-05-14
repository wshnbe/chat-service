package com.chat.letter.datasource.ann;

import com.alibaba.fastjson.JSON;
import com.chat.letter.datasource.DataSourceHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class MasterAop {

    @Pointcut("@annotation(com.chat.letter.datasource.ann.Master)")
    public void pointCut(){}

    @Before("pointCut()")
    public void before(JoinPoint point){
        DataSourceHolder.setMaster();
    }

    @After("pointCut()")
    public void after(){
        DataSourceHolder.removeDataSource();
    }
}
