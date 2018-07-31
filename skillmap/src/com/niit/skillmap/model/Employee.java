package com.niit.skillmap.model;

public class Employee {
	
	private int id;
	private String name;
	private String type;
	private String email;
	private String password;
	private String phone;
	private boolean flag;
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public Employee(int id,String name,String type,String email,String password,String phone,boolean flag)
	{
		this.id=id;
		this.name=name;
		this.type=type;
		this.email=email;
		this.password=password;
		this.phone=phone;
		this.flag=flag;
		
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", type=" + type + ", email=" + email + ", password="
				+ password + ", phone=" + phone + ", flag=" + flag + "]";
	}

	
	
	

}
