package com.niit.exercise.daythree;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Ppiper {

	public static void main(String[] args)
	{
	 PipedInputStream pis = new PipedInputStream();
	    PipedOutputStream pos = new PipedOutputStream();
	    try {
			pos.connect(pis);
			
			Thread t1=new Thread((Runnable) pis);
			Thread t2=new Thread((Runnable) pos);
			
			t1.start();
			t2.start();
			
			Client c=new Client(t1);
			
			FServer s=new FServer(t2);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}

	
		
		
	
}
