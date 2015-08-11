

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestGreatestCommonDivisor {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGreatestCommonDivisor1()
	{
		GreatestCommonDivisor greatestCommonDivisor =new GreatestCommonDivisor();//create instance of GreatestCommonDivisor Class 
		int actual=greatestCommonDivisor.gcd(2, 1);
		assertEquals(1, actual);
	}
	@Test
	public void testGreatestCommonDivisor2()
	{
		GreatestCommonDivisor greatestCommonDivisor =new GreatestCommonDivisor();//create instance of GreatestCommonDivisor Class 
		int actual=greatestCommonDivisor.gcd(12, 18);
		assertEquals(6, actual);
	
	}
	@Test
	public void testGreatestCommonDivisor3()
	{
		GreatestCommonDivisor greatestCommonDivisor =new GreatestCommonDivisor();//create instance of GreatestCommonDivisor Class 
		int actual=greatestCommonDivisor.gcd(100, 3);
		assertEquals(1, actual);
	}



}
