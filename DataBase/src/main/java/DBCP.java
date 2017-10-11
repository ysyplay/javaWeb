import org.apache.commons.dbcp.BasicDataSource;

import java.sql.*;

/**
 * Created by runa on 2017/8/14.
 */
public class DBCP {
    static Connection connection = null;
    static PreparedStatement preparedStatement = null;
    static ResultSet resultSet = null;

    public static BasicDataSource ds = null;
    static final String DRIVE = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/cloud_study?useCursorFetch=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASSWORD = "root";
    public static void  dbPoolInit()
    {
          ds = new BasicDataSource();
          ds.setUrl(DB_URL);
          ds.setDriverClassName(DRIVE);
          ds.setUsername(USER);
          ds.setPassword(PASSWORD);
    }
    public static void DBCPTest() throws SQLException {
        try {
            connection = ds.getConnection();
            String sql = "select * from user";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setFetchSize(5);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next())
            {
                System.out.println(resultSet.getNString("userName")+"  "+resultSet.getNString("sex"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //事务 原子性 一致性 隔离性 持久性
    public static void commitTest() throws SQLException {
        Savepoint sp = null;
        try {
            connection = ds.getConnection();
            connection.setAutoCommit(false);//开启事务模式
            String sql = "update user set account = ? where userName = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,0);
            preparedStatement.setString(2 ,"张三丰");
            preparedStatement.execute();
            sp = connection.setSavepoint();//断点保存，回滚后接着断点执行SQL
            preparedStatement.setInt(1,100);
            preparedStatement.setString(2 ,"赵云");
            preparedStatement.execute();
            throw new SQLException();

        } catch (SQLException e) {
            if (connection!=null)
            {
                connection.rollback(sp);
                preparedStatement.setInt(1,100);
                preparedStatement.setString(2 ,"小赵");
                preparedStatement.execute();
                connection.commit();
            }
            e.printStackTrace();
        }finally {
            try {
                clear();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void clear() throws SQLException {
        if (connection!=null)
        {
            connection.close();
        }
        if (preparedStatement!=null)
        {
            preparedStatement.close();
        }
        if (resultSet!=null)
        {
            resultSet.close();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException
    {
        dbPoolInit();
        try {
            commitTest();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
