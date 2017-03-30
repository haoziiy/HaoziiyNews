package com.haoziiy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by sherry on 2017/3/30.
 */
@Aspect
@Component
public class LogAspect {
   private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
   @Before("execution(* com.haoziiy.controller.*Controller.*(..))")
   public void beforMethod(JoinPoint joinPoint){
       StringBuffer sb = new StringBuffer();
       for(Object arg : joinPoint.getArgs())
       {
           sb.append("arg:" + arg.toString() + "|");
       }
       logger.info("before time : " + new Date());
       logger.info("before method : " + sb);
   }
   @After("execution(* com.haoziiy.controller.*Controller.*(..))")
   public void afterMethod(JoinPoint joinPoint){
     //  logger.info("after time : " + new Date());
       logger.info("after method : ");
   }

}
