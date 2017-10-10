package com.netease.course;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component("screwDriver")
public class ScrewDriver {
	@Resource //自动装配
	private Header header;
	
	public void use() {
		System.out.println("Use header: " + header.getInfo());
		header.doWork();
	}
}
