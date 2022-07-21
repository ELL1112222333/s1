//package org.example.aspect;
//
//import lombok.extern.slf4j.Slf4j;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.aspectj.lang.reflect.MethodSignature;
//import org.example.aopannotation.Action;
//import org.springframework.stereotype.Component;
//
//import java.lang.reflect.Method;
//
//@Slf4j
//@Aspect
//@Component
//public class LogAspect {
//    @Pointcut("@annotation(org.example.aopannotation.Action)")
//    public void annotationPoinCut(){}
//
//    @Before("annotationPoinCut()")
//    public void before(JoinPoint joinPoint) {
//
//        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        Method method = signature.getMethod();
//
//
//        Action action = method.getAnnotation(Action.class);
//        log.info("注解式拦截 "+action.aopname());
//    }
//}
