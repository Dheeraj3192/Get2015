

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestRemainder {

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
	public void testRemainder1() {
		Remainder remainder =new Remainder();
		int actual=remainder.rem(2, 1);
		assertEquals(0, actual);
		
	}
	@Test
	public void testRemainder2() {
		Remainder remainder =new Remainder();
		int actual=remainder.rem(2, 0);
		assertEquals(-1, actual);
	}
	@Test
	public void testRemainder3() {
		Remainder remainder =new Remainder();
		int actual=remainder.rem(100,3);
		assertEquals(1, actual);
		
	}
	@Test
	public void testRemainder4() {
		Remainder remainder =new Remainder();
		int actual=remainder.rem(0, 2);
		assertEquals(0, actual);
	}

}
