package com.netease.course;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository("mybatisUserDao")
public interface MybatisUserDao {
	//这里用来对应和模型的属性
	@Results({ 
		@Result(property = "balance", column = "balance"),
		@Result(property = "user", column = "user")
	}
	)
	@Select("select * from account where user=#{user}")
	public User getUser(String user);

	@Results({ 
		@Result(property = "balance", column = "balance"),
			@Result(property = "user", column = "user")
	}
	)
	@Select("Select * from account")
	public List<User> getUserList();
}
