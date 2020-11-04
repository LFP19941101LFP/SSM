/**
 * 
 */
package com.spring.pojo;

/**  
* 钥匙表
* @Title: Key.java  
* @Package com.spring.pojo    
* @author LiFupeng  
* @date 2020年9月4日  
* @company alibaba
* @version V1.0  
*/
public class Key {
	private Integer id ;
	private String keyName;
	
	//锁子.级联属性
	private Lock lock;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public Lock getLock() {
		return lock;
	}

	public void setLock(Lock lock) {
		this.lock = lock;
	}

	@Override
	public String toString() {
		return "Key [id=" + id + ", keyName=" + keyName + ", lock=" + lock + "]";
	}

	public Key(Integer id, String keyName, Lock lock) {
		super();
		this.id = id;
		this.keyName = keyName;
		this.lock = lock;
	}

	public Key() {
		super();
	}
	

	
	

}
