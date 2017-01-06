

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestLinearSearch {

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
	public void testLinearSearch1() {
		LinearSearch linearSearch=new LinearSearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=55,index=0;
		int isFound=linearSearch.linearSearch(inputArray, searchNumber, index);
		assertEquals(5, isFound);
	}
	@Test
	public void testLinearSearch2() {
		LinearSearch linearSearch=new LinearSearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=-5,index=0;
		int isFound=linearSearch.linearSearch(inputArray, searchNumber, index);
		assertEquals(-1, isFound);
	}
	@Test
	public void testLinearSearch3() {
		LinearSearch linearSearch=new LinearSearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=59,index=0;
		int isFound=linearSearch.linearSearch(inputArray, searchNumber, index);
		assertEquals(-1, isFound);
	}

}
