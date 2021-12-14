package com.gmell.labthree;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


//•Before – выполняется до метода с основной логикой
//•After returning – выполняется только после того, как метод корректно отработал
//•After throwing – выполняется после метода с основной логикой, если было выброшено исключение
//•After / After finally – выполняется после метода с основной логикой (в любом случае)
//•Around – выполняется и до, и после

@Component
@Aspect
public class MyAspect {

//Class, String, Integer
    @Pointcut("execution( IStorable[]  Withdraw(*, *, *))")
    private void Withdrawal(){}

    @Before("Withdrawal()")
    public void  beforeWithdrawAdvice(JoinPoint joinPoint){
        Object cl = joinPoint.getArgs()[0];
        Object name = joinPoint.getArgs()[1];
        Object amount = joinPoint.getArgs()[2];
        System.out.println(String.format("%s пытается списать %s обьект(ов) типа %s", name, amount,cl));
    }
    @AfterReturning("Withdrawal()")
    public void  afterRetWithdrawAdvice(){
        System.out.println("и у него даже получилось");
    }

    @After("Withdrawal()")
    public void  afterWithdrawAdvice(){
        System.out.println("он идет на выход");
    }
    @AfterThrowing(pointcut = "Withdrawal()", throwing = "exception")
    public void  afterThrowWithdrawAdvice(Exception exception){
        System.out.println("и у него не получилось поскольку ");
        if(exception.getClass() == IllegalArgumentException.class){
            System.out.println("чот многовато захотел");
        }else if(exception.getClass() == ClassCastException.class){
            System.out.println("вообще не на тот склад пришел");
        }else{
            System.out.println("прям вообще дурак");
        }
    }
    @Around("Withdrawal()")
    public Object aroundWithdrawAdvice(ProceedingJoinPoint jp){

        Object ret = null;
        System.out.println("кто пришел???");
            try {
               ret = jp.proceed();
            } catch (Throwable e) {
            }
        System.out.println("а, ладно, он ушел");
        return ret;

    }
}
