package org.java_based.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class OpenDoorAspect {

    @Before("execution(* org.java_based.aop.OpenDoor.*(..))")
    public int before(JoinPoint joinPoint){
        System.out.println("Before method : " + joinPoint.getSignature().getName());
        System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));

        return -1;
    }

    @After("execution(* org.java_based.aop.OpenDoor.*(..))")
    public void after(JoinPoint joinPoint){
        System.out.println("After method : " + joinPoint.getSignature().getName());
        System.out.println("Arguments : " + Arrays.toString(joinPoint.getArgs()));
    }

    @Around("execution(* org.java_based.aop.OpenDoor.*(..))")
    public int around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Around Method : " + proceedingJoinPoint.getSignature().getName());
        System.out.println("Before");

        Object result = proceedingJoinPoint.proceed();
        System.out.println("Return value : " + result);

        System.out.println("After");

        if (result == null) {
            return -1; // Return a default int value instead of null
        }

        return (int) result;
    }

    @AfterReturning(pointcut = "execution(* org.java_based.aop.OpenDoor.*(..))", returning = "res")
    public void returnCatch(JoinPoint joinPoint, Object res){
        System.out.println("After Returning : "+ res);
    }

    @AfterThrowing(pointcut = "execution(* org.java_based.aop.OpenDoor.*(..))", throwing = "exception")
    public void catchErr(JoinPoint joinPoint, Throwable exception){
        System.out.println("Exception caught:");
        System.out.println(exception.getLocalizedMessage());
    }

}
