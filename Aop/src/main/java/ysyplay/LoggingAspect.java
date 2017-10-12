package ysyplay;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by ysyplay on 2017/9/7.
 */
//其实相当于一个横切的类，不需要耦合别的类，自动检索匹配条件
@Aspect
public class LoggingAspect
{
    //这里的注解相当于指出在何时，何处执行何种操作
    @Before("execution(* ysyplay.Caculator.*(..)) && args(a, ..)")
    private void arithmeticDoLog(JoinPoint jp, int a) {
        System.out.println(a + ": " + jp.toString());
    }
}
