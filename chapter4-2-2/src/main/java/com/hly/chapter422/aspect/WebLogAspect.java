package com.hly.chapter422.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * code is far away from bug with the animal protecting
 * ┏┓　　　┏┓
 * ┏┛┻━━━┛┻┓
 * ┃　　　　　　　┃
 * ┃　　　━　　　┃
 * ┃　┳┛　┗┳　┃
 * ┃　　　　　　　┃
 * ┃　　　┻　　　┃
 * ┃　　　　　　　┃
 * ┗━┓　　　┏━┛
 * 　　┃　　　┃神兽保佑
 * 　　┃　　　┃代码无BUG！
 * 　　┃　　　┗━━━┓
 * 　　┃　　　　　　　┣┓
 * 　　┃　　　　　　　┏┛
 * 　　┗┓┓┏━┳┓┏┛
 * 　　　┃┫┫　┃┫┫
 * 　　　┗┻┛　┗┻┛
 * ---------------------------------
 *
 * @Author : Hu.Liangyan
 * @Date : Create in 2018/12/20 11:47
 */


@Component
@Aspect
@Order(2)
public class WebLogAspect {

    ThreadLocal<Long> startTime = new ThreadLocal<Long>();
    private Long start;
    private Logger logger = Logger.getLogger(getClass());

    @Pointcut("execution(public * com.hly.chapter422.web..*.*(..))")
    public void webLog(){}

    @Before("webLog()")
    public void before(JoinPoint joinPoint){

        startTime.set(System.currentTimeMillis());
        start = System.currentTimeMillis();
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        logger.info(request.getRequestURL());
        logger.info(request.getRemoteAddr());
        logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));

    }


    @AfterReturning(value = "webLog()", returning = "ret")
    public void afterReturn(Object ret){
        Long time = System.currentTimeMillis() - this.start;
        ret = ret + ", time:"+time+",start:"+start;
        logger.info("return: " + ret);

        logger.info("spend:" + (System.currentTimeMillis() - startTime.get()));
    }

}
