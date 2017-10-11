package resultMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by runa on 2017/8/16.
 */
public class Test
{
    public static void main(String[] args)
    { // 1. 声明配置 件的 录渎职
        String resource = "conf.xml";
// 2. 加载应 配置 件
        InputStream is = Test.class.getClassLoader()
                .getResourceAsStream(resource);
// 3. 创建SqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder()
                .build(is);
// 4. 获取Session
        SqlSession session = sessionFactory.openSession();
        try {
// 5. 获取操作类
            UserOp userOp = session.getMapper(UserOp.class);
// 6. 完成查询操作
            Student user = userOp.getUser(2); System.out.println(user.getId() + " " + user.getUserName() + "");
            System.out.println(user.getCourses().get(0).getCourseName() +" ");
            System.out.println(user.getCourses().get(0).getTeacher()
                    .getTeacherName());
        }
        finally
        {
// 7.关闭Session
            session.close();
        }
    }
}
