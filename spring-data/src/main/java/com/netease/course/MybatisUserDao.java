package com.netease.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("mybatisUserDao")
public interface MybatisUserDao {
	@Results({ 
		@Result(property = "id", column = "id"), 
		@Result(property = "firstName", column = "first_name"),
		@Result(property = "lastName", column = "last_name") }
	)
	@Select("select * from user where firt_name=#{firstName}")
	public User getUser(String firstName);

	@Results({ 
		@Result(property = "id", column = "id"), 
		@Result(property = "firstName", column = "first_name"),
		@Result(property = "lastName", column = "last_name") }
	)
	@Select("Select * from user")
	public List<User> getUserList();
}
