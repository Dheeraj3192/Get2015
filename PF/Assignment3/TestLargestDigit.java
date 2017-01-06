

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLargestDigit {

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
	public void testLargestDigit1()
	{
		LargestDigit largestDigit=new LargestDigit();
		int actual=largestDigit.largestDigit(2);
		assertEquals(2, actual);
	}
	@Test
	public void testLargestDigit2()
	{
		LargestDigit largestDigit=new LargestDigit();
		int actual=largestDigit.largestDigit(1257369);
		assertEquals(9, actual);
	}
	@Test
	public void testLargestDigit3()
	{
		LargestDigit largestDigit=new LargestDigit();
		int actual=largestDigit.largestDigit(444);
		assertEquals(4, actual);
	}
		

}
