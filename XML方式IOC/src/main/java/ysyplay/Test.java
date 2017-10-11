package ysyplay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by ysyplay on 2017/9/5.
 */
public class Test
{
    public static void main(String[] args) {
        //初始化容器
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

        Header StraightHeader = context.getBean("StraightHeader",StraightHeader.class);
        StraightHeader.doWork();

        ScrewDriver screwDriver = context.getBean("screwDriver",ScrewDriver.class);
        screwDriver.use();

        //演示销毁
//        ((ConfigurableApplicationContext)context).close();
    }

}
