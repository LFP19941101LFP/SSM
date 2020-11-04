package com.spring.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.spring.dao.TeacherDao;
import com.spring.pojo.Teacher;

/**
 * 自定义封装规则
 * @author ASUS
 *
 */
public class TestTeacher {
	
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

	/**
	 * 根据id查询
	 * @throws IOException
	 */
	@Test
	public void getTeacherByIdTest() throws IOException {
		sqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			Teacher teacher = mapper.getTeacherById(2);
			System.out.println(teacher);
		} finally {
			openSession.close();
		}
	}
	
	
	/**
	 * 按照一定的条件查询老师的信息
	 * @throws IOException
	 */
	@Test
	public void getTeacherByAll() throws IOException {
		sqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			Teacher teacher = new Teacher();
			// 根据传入的条件动态的拼接SQL语句,传入那个查询的条件就拼接那个SQL,,去除多余的
			//teacher.setId(1);
			teacher.settName("%四");
			/*teacher.setBirth(new Date());*/
			List<Teacher> list = mapper.getTeacherByAll(teacher);
			System.out.println(list);
		} finally {
			openSession.close();
		}
	}
	
	
	/**
	 * 按照一定的条件查询老师的信息 使用sql choose判断
	 * @throws IOException
	 */
	@Test
	public void getTeacherList() throws IOException {
		sqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			Teacher teacher = new Teacher();
			/*teacher.setId(2);
			teacher.setcName("张三");
			teacher.setBirth(new Date());*/
			List<Teacher> list = mapper.getTeacherByAllChoose(teacher);
			System.out.println(list);
		} finally {
			openSession.close();
		}
	}
	
	
	/**
	 * 按照一定的条件查询老师的信息 使用sql choose判断
	 * @throws IOException
	 */
	@Test
	public void updateTeacherTest() throws IOException {
		sqlSessionFactory();
		
		SqlSession openSession = sqlSessionFactory.openSession(true);
		
		try {
			
			TeacherDao mapper = openSession.getMapper(TeacherDao.class);
			Teacher teacher = new Teacher();
			teacher.setId(2);
			teacher.settName("黄老师");
			mapper.updateTeacher(teacher);
			//openSession.commit();
			System.out.println(teacher);
		} finally {
			openSession.close();
		}
	}
}
