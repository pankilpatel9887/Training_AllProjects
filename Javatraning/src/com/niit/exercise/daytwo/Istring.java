package com.niit.exercise.daytwo;

public class Istring {

		String str;
		String revstr;

public String getStr() {
			return str;
		}
		public void setStr(String str) {
			this.str = str;
		}
		
		
public String stringRev()
{
	 StringBuilder sb = new StringBuilder();
	 sb.reverse();
	 revstr=sb.toString();
	return revstr.toString();
}

public void equalString(Istring s2)
{
	int len=this.revstr.length();
	int len2=s2.revstr.length();
	int i;
	int tmp=0;
	
	if(len==len2)
	{
		for(i=0; i<len; i=i+2)
		{
			if(this.revstr.charAt(i)==s2.revstr.charAt(i))
			{
				tmp++;
				
			}
				
		}
	}
	if(tmp>1)
	{
		System.out.println("equal");
	}
	else
	{
		System.out.println("not equal");
	}
}
	public static void main(String[] args) {
		

		Istring is=new Istring();
		Istring is1=new Istring();
		is.setStr("abcd");
		is1.setStr("adbccbsa");
		is.stringRev();
		is1.stringRev();
		
	    is.equalString(is1);
		
	    
	}

}

