package org.example.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopannotation.Action;
import org.example.utils.Result;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class LogAspect {
    @Pointcut("@annotation(org.example.aopannotation.Action)")
    public void annotationPoinCut(){}

    @Before("annotationPoinCut()")
    //@After("annotationPoinCut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        log.info("注解式拦截 "+action.aopname());
        //System.out.println("注解式拦截 "+action.aopname());

//        Object result = joinPoint.proceed();
//        Result resp = (Result) result;

//        try {
//            //实现保存日志逻辑
//            log.info();
//        } catch (Exception e) {
//            log.error("日志记录失败 {}", e.getMessage());
//        }
//        return result;
    }

    /*@Before("execution(* org.example.service.DemoMethodService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("方法规则式拦截,"+method.getName());
    }*/

}
