package com.netease.course;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestData {

	public static void main(String[] args) throws Exception
	{
//		 testAccount();
         testMybatis();
	}
	public static void testAccount()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		AccountDao accountDao = context.getBean("accountDao",AccountDao.class);
		accountDao.resetMoney();
		try {
		accountDao.transferMoney("li","han",500);
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
		List<Account> accountList = accountDao.accountList();
		for (Account account:accountList)
		{
			System.out.println(account);
		}

	}


	public static void testMybatis()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");

		MybatisUserDao dao = context.getBean("mybatisUserDao", MybatisUserDao.class);
		List<User> userList = dao.getUserList();
		for (User user: userList) {
			System.out.println(user.getUser() + " " + user.getBalance());
		}

		User liLei = dao.getUser("li");
		System.out.println("Name: " + liLei.getUser() + " " + liLei.getBalance());

		((ConfigurableApplicationContext) context).close();

	}
}
