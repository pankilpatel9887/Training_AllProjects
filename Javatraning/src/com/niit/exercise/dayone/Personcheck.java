package com.niit.exercise.dayone;

import java.util.Scanner;

class Person
{
	
	String fname,lname,gender,color,address,parenttype;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPerenttype() {
		return parenttype;
	}

	public void setPerenttype(String perenttype) {
		this.parenttype = perenttype;
	}
	
	public void acceptData()
	{
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Fristname");
		fname=sc.nextLine();
		
		System.out.println("Enter Lastname");
		lname=sc.nextLine();
		
		System.out.println("Enter Gender");
		gender=sc.nextLine();
		
		System.out.println("Enter color");
		color=sc.nextLine();
		
		
		System.out.println("Enter Address");
		address=sc.nextLine();
		
		System.out.println("Enter parenttype");
		
		parenttype=sc.nextLine();
		
	}
}

 class Child extends Person
{
	public Child(String gender)
	{
		this.gender=gender;
		
	}

	public String color,gender,lname,address;
	
	public void decideChild(Person father,Person mother) {
		
		if(gender.equalsIgnoreCase("male"))
		{
			if(father.getColor().equals(mother.getColor())) {
				
				color="blue";
				lname=father.getLname();
				address=father.getAddress();
				
			}
			else
			{
				color=(String) mother.getColor();
				lname=father.getLname();
				address=father.getAddress();
			}
		}
		else if(gender.equalsIgnoreCase("female"))
		{
			color=(String) father.getColor();
			lname=father.getLname();
			address=father.getAddress();
		}
	}		
	 void childInfo()
		{
			System.out.println("gender:"+gender);
			System.out.println("color:"+color);
			System.out.println("Lastname:"+lname);
			System.out.println("Address:"+address);
		}
	}
		
	

public class Personcheck
{
	public static void main(String [] args)
	{
		Person father=new Person();
		
		father.acceptData();
		
		Person mother=new Person();
		
		mother.acceptData();
		
		Scanner sc=new Scanner(System.in);
		
		System.out.println("ENter Gender Of child::");
		
		String cg=sc.nextLine();
		
		Child c=new Child(cg);
		
		c.decideChild(father, mother);
		c.childInfo();
	}

	
}