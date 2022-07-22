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


import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;

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

    //@Before("pointCut()")
    @Around("pointCut()")
    //public void beforeMethod(JoinPoint joinPoint){
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        //2
        long startTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();

        Action action = method.getAnnotation(Action.class);


        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();

        HttpServletRequest request = servletRequestAttributes.getRequest();

        //2
        WebLog webLog = new WebLog();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();

//获取需要打印的参数信息
        String requestURI = request.getRequestURI();
        String usingmethod = request.getMethod();
        String remoteAddr = request.getRemoteAddr();
//这里使用的是阿里的fastjson
        String jsonString = JSON.toJSONString(joinPoint.getArgs());

//打印信息
        //2
        String urlStr = request.getRequestURL().toString();
        webLog.setBasePath(StrUtil.removeSuffix(urlStr, URLUtil.url(urlStr).getPath()));
        webLog.setIp(request.getRemoteUser());
        webLog.setMethod(request.getMethod());
        //改
        webLog.setDescription(action.aopname());
        //webLog.setParameter(getParameter(method, joinPoint.getArgs()));
        webLog.setParameter(jsonString);
        webLog.setResult(result);
        webLog.setSpendTime((endTime - startTime)+"ms");
        //webLog.setStartTime(startTime);
        webLog.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        webLog.setUri(request.getRequestURI());
        webLog.setUrl(request.getRequestURL().toString());
        logger.info("{}", JSONUtil.parse(webLog));
        return result;

//        logger.info("------------------------请求信息----------------------------------");
//        logger.info("请求时间 ：{}",new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
//        logger.info("Description: {}",action.aopname());
//        logger.info("remoteAddr: {} ",remoteAddr);
//        logger.info("requestURI : {}",requestURI);
//        logger.info("Controller : {}", joinPoint.getTarget().getClass());
//        logger.info("method type: {}" ,usingmethod);
//        logger.info("req paras: {}",jsonString);
//        logger.info("------------------------请求信息-----------------------------------");
//        //return result;
    }

}