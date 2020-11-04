package com.spring.pojo;

import java.util.Date;

/**
 * 实体类
 * @author ASUS
 *
 */
public class Teacher {

	private Integer id;
	private String tName;
	private String cName;
	private Date birth;
	private String address;
	public Teacher() {
		super();
	}
	public Teacher(Integer id, String tName, String cName, Date birth, String address) {
		super();
		this.id = id;
		this.tName = tName;
		this.cName = cName;
		this.birth = birth;
		this.address = address;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Teacher [id=" + id + ", tName=" + tName + ", cName=" + cName + ", birth=" + birth + ", address="
				+ address + "]";
	}
	
	
}
