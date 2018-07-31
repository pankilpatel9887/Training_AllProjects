package com.niit.meven.testmeven;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
        //Using Resource display constructor value
//    	Resource res = new ClassPathResource("beans.xml");
//    	BeanFactory ft=new XmlBeanFactory(res);
//    	Car c=(Car) ft.getBean("car");
//    	c.disp();
    	
    	//Using Application context display constructor value
    	ApplicationContext con=new ClassPathXmlApplicationContext("beans.xml");
    	Car c=(Car) con.getBean("car");
    	Car c1=(Car) con.getBean("car");
    	if(c==c1)
    	{
    		System.out.println("success");
    		c.disp();	
    	}
    	
    }
}
