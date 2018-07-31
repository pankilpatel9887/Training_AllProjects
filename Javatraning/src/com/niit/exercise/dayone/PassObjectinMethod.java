package com.niit.exercise.dayone;


interface myInterface
{
	void compute();
}
class Rectangle implements myInterface
{

	@Override
	public void compute() {
		// TODO Auto-generated method stub
		System.out.println("test");
		
	}
	
}
public class PassObjectinMethod {

		void displayData(myInterface myface)
		{
			myface.compute();
		}
		public static void main(String [] args)
		{
			 PassObjectinMethod m=new  PassObjectinMethod();
			 Rectangle r=new Rectangle();
			 
			 m.displayData(r);
			
		}
	
	
}
