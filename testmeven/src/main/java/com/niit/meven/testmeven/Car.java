package com.niit.meven.testmeven;

public class Car {

	private String name;
	private int modelno;
	
	


	public void setName(String name) {
		this.name = name;
	}


	
	public void setModelno(int modelno) {
		this.modelno = modelno;
	}


	
	
	

	



//	
//	public Car(String name, int modelno) {
//		
//		this.name = name;
//		this.modelno = modelno;
//	}

	
	public void disp()
	{
		System.out.println("name"+name);
		System.out.println("Modelno"+modelno);
	}
	
	
}
