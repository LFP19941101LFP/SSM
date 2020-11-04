package com.alibaba.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.spring.Person;

public class PersonTest01 {
	//从容器中获取ioc组件
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc2.xml");

	/**
	 * 测试单实例Bean:singleton
	 */
	@Test
	public void test() {
		System.out.println("容器启动完成....");
		Person bean = (Person) ioc.getBean("person01");
		Person bean2 = (Person) ioc.getBean("person01");
		System.out.println(bean == bean2);
		
	}

}
