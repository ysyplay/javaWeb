package ysyplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.activation.DataSource;

/**
 * Created by ysyplay on 2017/10/10.
 */
@Repository
public class JdbcTemplateDao
{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void  setJdbcTemplate(JdbcTemplate jdbcTemplate)
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    public  void creatTable()
    {
        jdbcTemplate.execute("CREATE TABLE springTable (id integer,name VARCHAR (100))");
    }
    public void insertData()
    {
        this.jdbcTemplate.update("INSERT INTO springTable VALUES (5,?)","小明");
    }
}
