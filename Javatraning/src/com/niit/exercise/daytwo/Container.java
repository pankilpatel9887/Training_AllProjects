package com.niit.exercise.daytwo;


 class CompareException extends Exception{  
	 CompareException(String s){  
	  super(s);  
	 }  
	}  


class Findvolume{  
	  int length,height,width;
	  
		int calculate(int len,int ht,int wth)
		{
			length=len;
			height=ht;
			width=wth;
			
			return len*ht*wth;
		}
	
	  	void validate()throws CompareException
	    {  
	  		int con=calculate(23,22,20);
	  		int rem=calculate(10, 10, 10);
	  		
		   if(rem>con)  
	      throw new CompareException("not valid");  
	     else  
	      System.out.println("done...");  
	   }  
}
public class Container {

	
	public static void main(String[] args)
	{
		try{  
			
			
		    Findvolume fv=new Findvolume(); 
			fv.validate();  
	
		}
		catch(Exception e)
		{System.out.println("Exception occured: "+e);}  
	}
}
