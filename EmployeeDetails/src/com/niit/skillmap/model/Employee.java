package com.niit.skillmap.model;

public class Employee {

	private int id;
	private String name;
	private String passowrd;
	private int age;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassowrd() {
		return passowrd;
	}

	public void setPassowrd(String passowrd) {
		this.passowrd = passowrd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	
	public Employee(int id,String name,String password,int age)
	{
		this.id=id;
		this.name=name;
		this.passowrd=password;
		this.age=age;
		
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	
}
