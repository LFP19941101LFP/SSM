package com.alibaba.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JDBCTest {
	
	ApplicationContext ioc = new ClassPathXmlApplicationContext("ApplicationContext.xml");

	@Test
	public void test() throws SQLException {
		
	}

}
