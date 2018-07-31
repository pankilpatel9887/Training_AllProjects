package com.niit.exercise.daythree;
import java.io.*;

public class Client implements Runnable { 
		 
	    InputStream input; 
	   OutputStream output; 
	  
	    public Client(InputStream input,OutputStream output) { 
	        this.input = input; 
	        this.output = output; 
	    }

		public Client(Thread t1) {
			// TODO Auto-generated constructor stub
			
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			  byte[] b = new byte[512]; 
	            int read = 1; 
	            while (read > -1)
	            { 
	                try {
						read = input.read(b, 0, b.length);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
	                if (read > -1)
	                { 
	                    try {
							output.write(b, 0, read);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	                } 
	 
	            }
	            
			}
}		
