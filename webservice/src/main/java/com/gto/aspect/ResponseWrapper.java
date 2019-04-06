package com.gto.aspect;

import com.gto.base.BaseResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ResponseWrapper {

    @Around("execution(* com.gto.api.*.*.*(..)) && !@annotation(com.gto.annotion.EscapeWrapper)")
    protected Object wrapper(ProceedingJoinPoint joinPoint) {
        BaseResponse br = null;
        try {
            Object data = joinPoint.proceed();
            br = new BaseResponse(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), data);
        } catch (Throwable e) {
//            LOGG.error("exception when wrapper data:{}", e.getMessage());
//            throw new GlobalException(Dict.Module.web, Dict.Factor.unknown, e);
        }
        return br;
    }
}
