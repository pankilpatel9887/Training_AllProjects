package com.niit.meven.testmeven;

import org.junit.After;
import org.junit.Before;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
	Calculatore c=null;
	@Before
	public void setUp()
	{
	 c=new Calculatore();
	}
	@After
	public void tearDown(Object c)
	{
		c=null;
	}
	
	public void testAdd()
	{
		assertEquals(60,c.add(20, 40));
		assertEquals(10, c.div(100, 10));
		
	}
	
	

}
