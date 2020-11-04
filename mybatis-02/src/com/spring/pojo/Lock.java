
package com.spring.pojo;

import java.util.List;

/**  
*  锁子表
* @Title: Lock.java  
* @Package com.spring.pojo    
* @author LiFupeng  
* @date 2020年9月4日  
* @company alibaba
* @version V1.0  
*/
public class Lock {
	private Integer id ;
	private String lockName;
	// 查询锁子把所有的钥匙都查到
	private List<Key> keys;
	
	
	public List<Key> getKeys() {
		return keys;
	}
	public void setKeys(List<Key> keys) {
		this.keys = keys;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLockName() {
		return lockName;
	}
	public void setLockName(String lockName) {
		this.lockName = lockName;
	}
	@Override
	public String toString() {
		return "Lock [id=" + id + ", lockName=" + lockName + ", keys=" + keys + "]";
	}
	public Lock() {
		super();
	}
	public Lock(Integer id, String lockName, List<Key> keys) {
		super();
		this.id = id;
		this.lockName = lockName;
		this.keys = keys;
	}
	
}
