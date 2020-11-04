/**
 * 
 */
package com.spring.dao;

import com.spring.pojo.Key;

/**  
* 
* @Title: KeyDao.java  
* @Package com.spring.dao    
* @author LiFupeng  
* @date 2020年9月4日  
* @company alibaba
* @version V1.0  
*/
public interface KeyDao {
	
	/**
	 * 根据id查询钥匙
	 * @param id
	 * @return
	 */
	Key getKeyById(Integer id);

}
