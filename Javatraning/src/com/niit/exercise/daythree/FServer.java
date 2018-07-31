package com.niit.exercise.daythree;

import java.io.InputStream;

public class FServer {

	public FServer(Thread t2) {
		// TODO Auto-generated constructor stub
	}

	public static InputStream pipe(Process... proc) throws InterruptedException
	{ 
       
        Process p1; 
        Process p2; 
        for (int i = 0; i < proc.length; i++) { 
            p1 = proc[i]; 
             
            if (i + 1 < proc.length) { 
                p2 = proc[i + 1]; 
                new Thread(new Client(p1.getInputStream(), p2.getOutputStream())).start(); 
            } 
        } 
        Process last = proc[proc.length - 1]; 
        last.waitFor(); 
        return last.getInputStream(); 
    } 
     


}
