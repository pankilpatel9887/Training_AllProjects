package com.niit.exercise.daytwo;

import java.lang.System;


class LessThanException extends Exception
{
	public void LessThanExcepton(String message)
	{
		System.out.println(message+"value 2 is less than value 1");
	}
	public String toString()
	{
		return "error";
	}
}


class GreaterThanException extends Exception
{
	public void LessThanExcepton(String message)
	{
		System.out.println(message+"value 2 is greater than value 1");
	}
	public String toString()
	{
		return "error";
	}
}

class Integr<T>
{
	T val;

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}
	
}
public class HashCodeDemo {

	private int num;
	void checkVal(Integr i1,Integr i2)throws GreaterThanException,LessThanException
	{
		int val1,val2 = 0;
		val1=(int)i1.getVal();
		
		if(val1>val2)
		{
			throw new GreaterThanException(); 
		}
		else
		{
			throw new LessThanException();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Integr<Integer> i=new Integr();
		i.setVal(223);
		
		Integr<Integer> i2=new Integr();
		i.setVal(60);
		
		HashCodeDemo hd=new HashCodeDemo();
		
		try
		{
			hd.checkVal(i, i2);
		}
		catch (GreaterThanException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		catch (LessThanException e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		finally {
			System.out.println("Finished Problem");
		}
		
		 
	

	
		
	
	}

}
