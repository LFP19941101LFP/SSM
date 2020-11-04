package com.alibaba.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.spring.Person;

public class PersonTest {
	//从ioc容器中获取组件,ApplicationContext代表ioc容器
	private ApplicationContext ioc = new ClassPathXmlApplicationContext("ioc.xml");
	
	//32
	
	
	/**
	 * 根据id获取bean,为bean属性赋值
	 */
	@Test
	public void test01() {
		//调用ioc的getBean方法
		Person p = (Person) ioc.getBean("person");
		System.out.println(p);
	}
	
	/**
	 * 根据bean的类型获取,为bean赋值属性
	 */
	@Test
	public void test02() {
		Person p = ioc.getBean("person02", Person.class);
		System.out.println(p+"===>>>class");
	}
	
	/**
	 * 根据有参构造方法获取bean实例
	 */
	@Test
	public void test03() {
		Person p = (Person) ioc.getBean("person03");
		System.out.println(p+"===>>>class");
	}
	
	/**
	 * 通过P名称空间为属性赋值
	 */
	@Test
	public void test04() {
		Person p = (Person) ioc.getBean("person04");
		System.out.println(p+"===>>>class");
	}


	
	
}
