package ysyplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ysyplay on 2017/10/10.
 */
//context扫描Dao，由dao去做操作
@Repository
public class JdbcTemplateDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired//自动装配JdbcTemplate，数据源早xml中定义
    public void  setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }
     //dao作上层操作，由jdbcTemplate执行sql语句
    public  void creatTable()
    {
        jdbcTemplate.execute("CREATE TABLE springTable (id integer,name VARCHAR (100))");
    }
    public void insertData()
    {
        this.jdbcTemplate.update("INSERT INTO springTable(id,name) VALUES (7,?)","小明");
    }
    //模型化操作
    public List<User> getUserList()
    {
        return this.jdbcTemplate.query("select * from springTable", new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet resultSet, int i) throws SQLException {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                return user;
            }
        });
    }
}
