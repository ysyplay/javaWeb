package ysyplay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ysyplay on 2017/9/7.
 */
public class Test
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Caculator caculator = context.getBean("caculator", Caculator.class);
        System.out.println(caculator.add(1, 1));
        System.out.println(caculator.sub(5, 2));
        System.out.println(caculator.getClass());

        ((ConfigurableApplicationContext) context).close();

    }
}
