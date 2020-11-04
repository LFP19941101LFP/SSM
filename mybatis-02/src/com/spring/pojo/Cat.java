package com.spring.pojo;

/**
 * 
 * @author ASUS
 *
 */
public class Cat {
	private Integer id;
	private String cName;
	private String cAge;
	private Integer cGender;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcAge() {
		return cAge;
	}
	public void setcAge(String cAge) {
		this.cAge = cAge;
	}
	public Integer getcGender() {
		return cGender;
	}
	public void setcGender(Integer cGender) {
		this.cGender = cGender;
	}
	@Override
	public String toString() {
		return "Cat [id=" + id + ", cName=" + cName + ", cAge=" + cAge + ", cGender=" + cGender + "]";
	}
	public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cat(Integer id, String cName, String cAge, Integer cGender) {
		super();
		this.id = id;
		this.cName = cName;
		this.cAge = cAge;
		this.cGender = cGender;
	}
	
	
}
