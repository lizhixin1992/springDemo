package com.blue.ssm.log;

import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @description:
 * @email:
 * @author: lizhixin
 * @createDate: 13:45 2017/9/11
 */
public class SystemLogAspect {

    private final Logger logger = LoggerFactory.getLogger(SystemLogAspect.class);


    public void before(JoinPoint joinPoint){
        //System.out.println("被拦截方法调用之后调用此方法，输出此语句");
        System.out.println("before========================");

        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes)ra;
        HttpServletRequest request = sra.getRequest();

        Object obj =request.getParameter("fileName");
        System.out.println("方法调用前: " + obj);


        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Method[] methods = targetClass.getMethods();
        String operationName = "";
        String operationType = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs!=null&&clazzs.length == arguments.length&&method.getAnnotation(SystemLog.class)!=null) {
                    operationName = method.getAnnotation(SystemLog.class).operationName();
                    operationType = method.getAnnotation(SystemLog.class).operationType();
                    System.out.println("operationName="+operationName+",operationType="+operationType);
                    break;
                }
            }
        }



    }
}
