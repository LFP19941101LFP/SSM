package com.alibaba.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.spring.BookService;

public class BookTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("TX.xml");

	@Test
	public void test() {
		BookService bookService = ioc.getBean(BookService.class);
		bookService.checkOut("tom", "isn-01");
		System.out.println("结账成功");
	}

}
