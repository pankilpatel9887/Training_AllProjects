package com.niit.exercise.dayone;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class GenericDemo {
	
	public static void main(String [] args)
	{
	ArrayList<Integer> a1=new ArrayList<Integer>();
	
	a1.add(123);
	a1.add(234);
	a1.add(333);
	a1.add(556);
	
	System.out.println("using for");
	for(int a:a1)
	{
		System.out.println(a);
	}
	
	//using iterator
	
	System.out.println("using Iteraotr");
	Iterator<Integer> it=a1.iterator();
	
	while(it.hasNext())
	{
		int i=it.next();
		
		System.out.println(i);
	}
	
	//using listiterator
	
	System.out.println("using ListIterator");
	
	ListIterator<Integer> lit=a1.listIterator();
	
	
	System.out.println("in forward  direction");
	while(lit.hasNext())
	{
		int i=lit.next();
		
		System.out.println(i);
	}
	
	
	System.out.println("in backward direction");
	while(lit.hasPrevious())
	{
		int i=lit.previous();
		System.out.println(i);
	}
	}
}
