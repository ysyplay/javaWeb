package ysyplay;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ysyplay on 2017/10/10.
 */
public class Test
{
    public static void main(String[] args)
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        JdbcTemplateDao dao = context.getBean("jdbcTemplateDao",JdbcTemplateDao.class);
//        dao.creatTable();
        dao.insertData();
        List<User> userList =  dao.getUserList();
        for (User user:userList)
        {
            System.out.print(user);
        }

     }
}
