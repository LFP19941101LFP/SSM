package com.alibaba.spring;

public class Person {
	private int age;
	private String name;
	private String gender;
	private String phone;
	
	public Person() {
		super();
		System.out.println("person被创建了...");
	}

	public Person(int age, String name, String gender, String phone) {
		super();
		this.age = age;
		this.name = name ;
		this.gender = gender;
		this.phone = phone;
		
		System.out.println("有参构造方法");
	}

	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", gender=" + gender
				+ ", phone=" + phone + "]";
	}

	
	
	
	
}
