package org.example.aspect;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.aopannotation.Action;
import org.example.entity.WebLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//@Slf4j
@Aspect
@Component
@Order(2)
public class WebLogAspect {
    private static final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);



    //切入点表达式，com.springboot.controller自己controller包的路径
    //@Pointcut("execution(public * org.example.controller..*.*(..))")
    @Pointcut("@annotation(org.example.aopannotation.Action)")
    public void pointCut(){

    }

    @Before("pointCut()")
    //Around("pointCut()")
    public void beforeMethod(JoinPoint joinPoint){

    //public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();


        Action action = method.getAnnotation(Action.class);

        //Object result = joinPoint.proceed();

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = servletRequestAttributes.getRequest();

//获取需要打印的参数信息
        String requestURI = request.getRequestURI();
        String usingmethod = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
//这里使用的是阿里的fastjson
        String jsonString = JSON.toJSONString(joinPoint.getArgs());

//打印信息
        logger.info("------------------------请求信息----------------------------------");
        logger.info("请求时间 ：{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        logger.info("Description: {}",action.aopname());
        logger.info("remoteAddr: {} ",remoteAddr);
        logger.info("requestURI : {}",requestURI);
        logger.info("Controller : {}", joinPoint.getTarget().getClass());
        logger.info("method type: {}" ,usingmethod);
        logger.info("req paras: {}",jsonString);
        logger.info("------------------------请求信息-----------------------------------");
        //return result;
    }

}