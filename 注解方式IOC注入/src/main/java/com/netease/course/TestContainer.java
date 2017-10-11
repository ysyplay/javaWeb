package com.netease.course;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestContainer {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		Header header = context.getBean("header", StraightHeader.class);
		System.out.println(header.getInfo());
		
		ScrewDriver screwDriver = context.getBean("screwDriver", ScrewDriver.class);
		screwDriver.use();
		
		((ConfigurableApplicationContext) context).close();
	}
}
