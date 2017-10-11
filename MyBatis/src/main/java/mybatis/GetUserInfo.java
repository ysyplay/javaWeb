package mybatis;

import org.apache.ibatis.annotations.*;

/**
 * Created by ysyplay on 2017/8/15.
 */
public interface GetUserInfo
{
    @Select("select id ,userName,corp from user where id =#{id}")//通过注解的方式映射
    public User getUser(int id);

    @Insert("insert into user (userName,corp) values (#{userName},#{corp})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void  addUser( User user);

    @Update("update user set userName = #{userName}, corp = #{corp} where id = #{id}")
    public  void updateUser(User user);

    @Delete("delete from user where id = #{id}")
    public  void  deleteUser(int id);
}
