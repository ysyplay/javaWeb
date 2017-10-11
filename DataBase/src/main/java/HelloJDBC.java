import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ysyplay on 2017/8/9.
 */
public class HelloJDBC {
    static final String JDBC_DRIVE = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://127.0.0.1/cloud_study?useCursorFetch=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASSWORD = "root";
    static  Connection conn = null;
    static  Statement  stmt = null;
    static  PreparedStatement ptmt = null;
    static  ResultSet  rs = null;

    public static void connectDB() throws  ClassNotFoundException,SQLException
    {
        Class.forName(JDBC_DRIVE);//装载驱动
        conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);//建立连接
        stmt = conn.createStatement();
    }
    //查询
    public static void search() throws ClassNotFoundException, SQLException {
        try {
            //3.执行SQL语句
//            rs = stmt.executeQuery("select * from user where username = '张三丰'");
            //3.2游标获取法
            String sql = "select * from user where sex = ?";
            ptmt = conn.prepareStatement(sql);
            ptmt.setFetchSize(2);
            ptmt.setString(1,"男");//这里的数字1，代表SQL语句的第一个？
            rs = ptmt.executeQuery();
            //获取执行结果
            while (rs.next())
            {
                System.out.println(rs.getNString("userName")+"  "+rs.getNString("sex"));
            }
        }catch (SQLException e)
        {
            //异常处理
            e.printStackTrace();
        }finally {
            //5.清理环境
            try
            {
                clear();
            }catch (SQLException e)
            {
                //ignore
            }
        }
    }
    //插入
    public static  void insertUser(HashSet<String> users) throws SQLException, ClassNotFoundException {
        try {
            String sql = "insert into user(userName,sex)values(?,?)";
            ptmt = conn.prepareStatement(sql);
            //3.执行SQL语句
            for (String user:users)
            {
                ptmt.setString(1,user);
                ptmt.setString(2,"女");
                ptmt.addBatch();
            }
            ptmt.executeBatch();
            ptmt.clearBatch();
        }catch (SQLException e)
        {
            //异常处理
            e.printStackTrace();
        }finally {
            //5.清理环境
            try
            {
                clear();
            }catch (SQLException e)
            {
                //ignore
            }
        }
    }
    //删除
    public static  void deleteUser(HashSet<String> users) throws SQLException, ClassNotFoundException {
        try {
            String sql = "delete from user where userName=?";
            ptmt = conn.prepareStatement(sql);
            //3.执行SQL语句
            for (String user:users)
            {
                ptmt.setString(1,user);
                ptmt.addBatch();
            }
            ptmt.executeBatch();
            ptmt.clearBatch();
        }catch (SQLException e)
        {
            //异常处理
            e.printStackTrace();
        }finally {
            //5.清理环境
            try
            {
                clear();
            }catch (SQLException e)
            {
                //ignore
            }
        }
    }
    //修改
    public static  void refreshUser(HashSet<String> users) throws SQLException, ClassNotFoundException {
        try {
            String sql = "update user set sex='男' where userName=?";
            ptmt = conn.prepareStatement(sql);
            //3.执行SQL语句
            for (String user:users)
            {
                ptmt.setString(1,user);
                ptmt.addBatch();
            }
            ptmt.executeBatch();
            ptmt.clearBatch();
        }catch (SQLException e)
        {
            //异常处理
            e.printStackTrace();
        }finally {
            //5.清理环境
            try
            {
                clear();

            }catch (SQLException e)
            {
                //ignore
            }
        }
    }
    public static void clear() throws SQLException {
        if (conn!=null)
        {
            conn.close();
        }
        if (stmt!=null)
        {
            stmt.close();
        }
        if (ptmt!=null)
        {
            ptmt.close();
        }
        if (rs!=null)
        {
            rs.close();
        }
    }
    public static void main(String[] args) throws ClassNotFoundException
    {
       HashSet<String> users = new HashSet<String>();
       users.add("路人甲");
       users.add("路人乙");
       users.add("路人丁");
        try {
            connectDB();
            refreshUser(users);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connectDB();
            search();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
