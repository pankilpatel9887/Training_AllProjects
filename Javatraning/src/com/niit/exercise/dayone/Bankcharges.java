package com.niit.exercise.dayone;

import java.util.Scanner; 

class BankAccount
{
	
	double balance;
	int wflag=0;
	int dflag=0;
	double rate;
	 
	public void withdrawAmt(double amt,double rate)
	{
		this.rate=rate;
		amt=amt+((amt*rate)/100);
		balance=balance-amt;
		wflag=1;
		
		
	}
	
	public void depositAmt(double amt,double rate)
	{
		
		this.rate=rate;
		amt=amt-((amt*rate)/100);
		
		balance=balance+amt;
		dflag=1;
		
	}
	
	public BankAccount(double balance)
	{
		this.balance=balance;
	}
	public double getBalance()
	{
		return balance;
	}
	
	public void choice()
	{
		double amt;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("ENter choice");
		System.out.println("1.deposit");
		System.out.println("2.withdarw");
		System.out.println("3.Balance");
		
		int ch=sc.nextInt();
		
		switch(ch)
		{
		case 1:
			System.out.println("Enter the amounnt to deposit");
			amt=sc.nextDouble();
			if(dflag==0)
			{
				depositAmt(amt, 0.25);
			}
			else
			{
				depositAmt(amt, 0.20);
			}
			break;
			
		case 2:
			System.out.println("enter the withdraw amount");
			amt=sc.nextDouble();
			if(wflag==0)
			{
				withdrawAmt(amt, 0.5);
			}else
			{
				withdrawAmt(amt, 0.40);
			}
			
			break;
		
		case 3:
			System.out.println(getBalance());
			break;
			
		}
	}
}

public class Bankcharges {
	
	public static void main(String []args)
	{
		int i=1;
		Scanner ss=new Scanner(System.in);
		System.out.println("Enter balance");
		double init=ss.nextDouble();
		BankAccount b=new BankAccount(init);
		
		System.out.println(b.getBalance());
		
		while(i==1)
			b.choice();
		
	}
}
