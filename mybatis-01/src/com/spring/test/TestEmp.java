package com.spring.test;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.spring.dao.EmployeeDao;
import com.spring.pojo.Employee;

public class TestEmp {
	
	SqlSessionFactory sqlSessionFactory;
	/**
	 * 创建SqlSession工厂,将整个抽取为一个方法,供其他增删改查的方法调用
	 * @Before junit的注解,代表在其他方法运行之前运行此方法
	 * @throws IOException
	 */
	@Before
	public void sqlSessionFactory() throws IOException {
		/*1.根据全局配置文件创建一个SqlSessionFactory
		 SqlSessionFactory是SqlSession的工厂,是创建SqlSession对象
		 SqlSession:sql会话,(代表和数据库的一次会话)
		 */
		String resource = "mybatis.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	/**
	 * 根据id所有
	 * @throws IOException 
	 */
	@Test
	public void getEmpTest() throws IOException{
		sqlSessionFactory();
		// 获取和数据的一次会话,得到连接getConnection();
		SqlSession session = sqlSessionFactory.openSession();
		// 调用dao层的方法
		Employee employee;
		try {
			// 使用SqlSession操作数据库
			EmployeeDao mapper = session.getMapper(EmployeeDao.class);
			employee = mapper.getEmpById(10);
		} finally {
			session.close();
		}
		System.out.println(employee);
	}
	
	/**
	 * 修改员工信息,根据员工id
	 * @throws IOException 
	 */
	@Test
	public void updateEmpTest() throws IOException{
		sqlSessionFactory();
		// 2.获取连接
		SqlSession session = sqlSessionFactory.openSession(true);
		
		//获取dao接口的实现(映射)
		EmployeeDao mapper = session.getMapper(EmployeeDao.class);
		// 调用dao层的方法
		try {
			// 使用SqlSession操作数据库
			int i = mapper.updateEmp(new Employee(7,"杨海宁",0,"113@qq.com")); 
			System.out.println(i);
		} finally {
			session.close();
		}
		System.out.println();
	}
	
	/**
	 * 添加员工
	 * @throws IOException
	 */
	@Test
	public void addEmpTest() throws IOException {
		
		sqlSessionFactory();
		
		// 2.获取连接,手动提交
		// SqlSession session = sqlSessionFactory.openSession();
		// openSession(true);自动提交
		SqlSession session = sqlSessionFactory.openSession(true);
		
		try {
			EmployeeDao mapper = session.getMapper(EmployeeDao.class);
			//返回受影响的行数,用i就收
			int i = mapper.insertEmp(new Employee(null,"Tomcat2",1,"113@qq.com"));
			System.out.println("受影响的行数:"+i);
		} finally {
			//运行成功,但数据没有插入数据,需要手动提交,或者在获取连接是设置openSession(true)自动提交
			//session.commit();
			session.close();
		}
	}
	
	/**
	 * 删除员工,传入要删除的员工的id
	 * @throws IOException
	 */
	@Test
	public void deleteEmpTest() throws IOException {
		sqlSessionFactory();
		
		//打开和数据库的一次和会话
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			//拿到连接后调用到层方法,执行删方法,传入要删除的员工的id
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			boolean emp = mapper.deleteEmp(9);
			System.out.println(emp);
		} finally {
			openSession.close();
		}
	}
	

	/**
	 * 查询所有员工
	 * @throws IOException
	 */
	@Test
	public void getEmpAll() throws IOException {
		sqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			List<Employee> empAll = mapper.getEmpAll();
			for (Employee employee : empAll) {
				System.out.println(employee);
			}
		} finally {
			openSession.close();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
