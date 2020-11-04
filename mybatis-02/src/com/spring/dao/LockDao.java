/**
 * 
 */
package com.spring.dao;

import com.spring.pojo.Lock;

/**  
* 
* @Title: LockDao.java  
* @Package com.spring.dao    
* @author LiFupeng  
* @date 2020年9月4日  
* @company alibaba
* @version V1.0  
*/
public interface LockDao {

	/**
	 * 查锁子将所有的钥匙也查出来
	 * @param id
	 * @return
	 */
	Lock getLockById(Integer id);
}
