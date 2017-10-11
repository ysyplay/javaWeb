package ysyplay;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by ysyplay on 2017/9/7.
 */
@Aspect
public class LoggingAspect
{
    @Before("execution(* ysyplay.Caculator.*(..)) && args(a, ..)")
    private void arithmeticDoLog(JoinPoint jp, int a) {
        System.out.println(a + ": " + jp.toString());
    }
}
