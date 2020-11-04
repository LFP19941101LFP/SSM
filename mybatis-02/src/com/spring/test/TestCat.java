package com.spring.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.spring.dao.CatDao;
import com.spring.pojo.Cat;

public class TestCat {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void sqlSessionFactory() throws IOException {
		/*1.根据全局配置文件创建一个SqlSessionFactory
		 SqlSessionFactory是SqlSession的工厂,是创建SqlSession对象
		 SqlSession:sql会话,(代表和数据库的一次会话)
		 */
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testGetCatById() throws IOException {
		sqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			CatDao mapper = openSession.getMapper(CatDao.class);
			Cat cat = mapper.getCatById(2);
			System.out.println("==============>" + cat);
		} finally {
			openSession.close();
		}
		
		
	}

}
