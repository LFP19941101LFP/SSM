package com.spring.test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * 添加员工.拿到新添加员工的主键值
	 * @throws IOException
	 */
	@Test
	public void insertEmpTest() throws IOException {
		sqlSessionFactory();
		// 2.获取连接,手动提交
		// SqlSession session = sqlSessionFactory.openSession();
		// openSession(true);自动提交
		SqlSession session = sqlSessionFactory.openSession(true);
		
		try {
			EmployeeDao mapper = session.getMapper(EmployeeDao.class);
			Employee e = new Employee(null,"张三丰",1,"114@qq.com");
			//返回受影响的行数,用i就收
			int i = mapper.insertEmp(e);
			System.out.println("受影响的行数:"+i);
			System.out.println("添加的员工的主键======>"+e.getId());
		} finally {
			//运行成功,但数据没有插入数据,需要手动提交,或者在获取连接是设置openSession(true)自动提交
			//session.commit();
			session.close();
		}
	}
	

	/**
	 * 查询所有员工,返回List
	 * @throws IOException
	 */
	@Test
	public void getEmpByListTest() throws IOException {
		sqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			// 返回值list
			List<Employee> empAll = mapper.getEmpByList();
			for (Employee employee : empAll) {
				System.out.println(employee);
			}
		} finally {
			openSession.close();
		}
	}
	
	/**
	 * 根据id查询员工,返回Map
	 * @throws IOException
	 */
	@Test
	public void getEmpIdByMap() throws IOException {
		sqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			
			//返回值map封装
			Map<String, Object> map = mapper.getEmpIdByMap(11);
			System.out.println(map);
		} finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试使用Map传参 和 #{},${}取值的使用场景
	 * @throws IOException
	 */
	@Test
	public void getEmpByIdAndNameMapTest() throws IOException {
		sqlSessionFactory();
		
		//打开和数据库的一次和会话
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			//拿到连接后调用到层方法,执行删方法,传入要删除的员工的id
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			Map<String,Object> map = new HashMap<>();
			map.put("id", 7);
			map.put("empName", "杨海宁");
			map.put("tableName", "t_employee");
			Employee employee = mapper.getEmpByIdAndNameMap(map);
			System.out.println(employee);
		} finally {
			openSession.close();
		}
	}
	
	/**
	 * 测试多参数入参 @param多参数入参的方式
	 * @throws IOException
	 */
	@Test
	public void getEmpByIdAndNameTest() throws IOException {
		sqlSessionFactory();
		
		//打开和数据库的一次和会话
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			//拿到连接后调用到层方法,执行删方法,传入要删除的员工的id
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			Employee employee = mapper.getEmpByIdAndName(11, "Tomcat");
			
			System.out.println(employee);
		} finally {
			openSession.close();
		}
	}
	
	/**
	 * 查询返回值是Map 
	 * @throws IOException
	 */
	@Test
	public void getEmpIdByMapAllTest() throws IOException {
		sqlSessionFactory();
		
		//打开和数据库的一次和会话
		SqlSession openSession = sqlSessionFactory.openSession(true);
		try {
			//拿到连接后调用到层方法,执行删方法,传入要删除的员工的id
			EmployeeDao mapper = openSession.getMapper(EmployeeDao.class);
			Map<Integer, Employee> map = mapper.getEmpIdByMapAll();
			
			System.out.println(map);
		} finally {
			openSession.close();
		}
	}
	
}
