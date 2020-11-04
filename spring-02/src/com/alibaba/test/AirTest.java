package com.alibaba.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AirTest {
	
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");

	/**
	 * 静态工厂造飞机
	 */
	@Test
	public void test() {
		System.out.println("容器启动完成.......");
		Object bean = ioc.getBean("airPlane01");
		System.out.println(bean);
	}
	
	/**
	 * 实例工厂造飞机
	 */
	@Test
	public void test2() {
		
		Object bean = ioc.getBean("airPlane02");
		System.out.println(bean);
		System.out.println("容器启动完成......." );
	}


}
