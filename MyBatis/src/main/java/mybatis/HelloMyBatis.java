package mybatis;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by ysyplay on 2017/8/15.
 */
public class HelloMyBatis
{
    public static void main(String[] args)
    {
        //1.声明配置文件目录
        String resource = "conf.xml";
        //2.加载配置文件
        InputStream is = HelloMyBatis.class.getClassLoader().getResourceAsStream(resource);
        //3.创建SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(is);
        Configuration configuration = sessionFactory.getConfiguration();
        configuration.addMapper(GetUserInfo.class);
        //4.获取Session
        SqlSession session = sessionFactory.openSession(true);//默认以事务的方式提交，true表示不是使用事务模式
        //5.获取操作类
        try
        {
            GetUserInfo getUserInfo = session.getMapper(GetUserInfo.class);
            //6.完成查询操作
            User user= getUserInfo.getUser(5);
            System.out.println(user.getId() + " " + user.getUserName() + " "
                    + user.getCorp());
            //插入
            User user1 = new User("小明","天喵");
            getUserInfo.addUser(user1);
            System.out.println(user1.getId());
            //跟新
            user1.setCorp("天猫");
            getUserInfo.updateUser(user1);
            //删除
            getUserInfo.deleteUser(user1.getId());
        }
        finally
        {
            // 7.关闭Session
            session.close();
        }
    }
}
