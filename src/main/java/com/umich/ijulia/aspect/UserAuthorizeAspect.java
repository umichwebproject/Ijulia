package com.umich.ijulia.aspect;

import com.umich.ijulia.enums.UserResultEnum;
import com.umich.ijulia.exception.USERException;
import com.umich.ijulia.utils.CookieUtil;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Aspect
@Component
public class UserAuthorizeAspect {
    @Pointcut("execution(public * com.umich.ijulia.controller.User*.*(..))"
            +"&& !execution(public * com.umich.ijulia.controller.LoginController.*(..))"
            +"||execution(public * com.umich.ijulia.controller.Question*.*(..))")
    public void verify(){}
    @Before("verify()")
    public void doVerify(){
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request,"token");
        if(cookie==null){
            throw new USERException(UserResultEnum.USER_EMPTY_PASSWORD);
        }
    }
}
