package com.spring.pojo;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Employee {

	private Integer id;
	//不能为空
	@NotEmpty
	private String lastName;
	
	// 数字格式化
	/*@NumberFormat(pattern="#,###,###,#")
	private Integer salary;*/
	
	// 生日日期格式化,必须是一个过去的时间
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past(message="必须为过去时间") 
	private Date birth;
	private String email;
	//1 male, 0 female
	private Integer gender;
	private Department department;
	
	public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}
	
	public Employee() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", birth=" + birth + ", email=" + email + ", gender="
				+ gender + ", department=" + department + "]";
	}
	
}
