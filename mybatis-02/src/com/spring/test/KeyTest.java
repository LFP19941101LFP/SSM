/**
 * 
 */
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

import com.spring.dao.KeyDao;
import com.spring.dao.LockDao;
import com.spring.pojo.Key;
import com.spring.pojo.Lock;

/**  
*
* @Title: KeyTest.java  
* @Package com.spring.test    
* @author LiFupeng  
* @date 2020年9月4日  
* @company alibaba
* @version V1.0  
*/
public class KeyTest {
	
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
	 * 联合查询,使用级联属性封装联合查询的结果
	 * 根据id查询钥匙的同时查询出锁子的信息,
	 * Key getKeyById(Integer id);
	 * @throws IOException 
	 */
	@Test
	public void getKeyByIdTest() throws IOException {
		sqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			KeyDao mapper = openSession.getMapper(KeyDao.class);
			Key keyId = mapper.getKeyById(3);
			System.out.println("==================>" + keyId);
		} finally {
			openSession.close();
		}
	}
	
	
	
	/**
	 * 查锁子将所有的钥匙也查出来
	 * Lock getLockById(Integer id);
	 * 封装List属性值
	 */
	@Test
	public void testGetLockById() throws IOException {
		
		sqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		
		try {
			LockDao mapper = openSession.getMapper(LockDao.class);
			Lock lock = mapper.getLockById(3);
			System.out.println("=====================>" + lock);
			System.out.println("所有的钥匙如下");
			List<Key> keys = lock.getKeys();
			for (Key key : keys) {
				System.out.println("=====================>" + key);
			}
		} finally {
			openSession.close();
		}
	}
}
