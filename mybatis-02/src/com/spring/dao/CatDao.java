package com.spring.dao;

import com.spring.pojo.Cat;

/**
 * 
 * @author ASUS
 *
 */
public interface CatDao {
	
	/**
	 * 根据id查询猫信息
	 * @param id
	 * @return
	 */
	Cat getCatById(Integer id);

}
