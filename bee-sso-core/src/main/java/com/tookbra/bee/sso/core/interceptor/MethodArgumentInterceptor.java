package com.tookbra.bee.sso.core.interceptor;

import com.tookbra.bee.sso.core.utils.ParamsValidationUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;

/**
 * @author tookbra
 * @date 2019/2/18
 * @description
 */
@Aspect
@Order(100)
public class MethodArgumentInterceptor {

    @Around("execution(* com.tookbra.bee..*.*Controller(..))")
    public Object paramsValidate(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
//        signature.getMethod()
        ParamsValidationUtil.validate(args);
        return joinPoint.proceed();
    }
}
