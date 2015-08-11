

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestBinarySearch {

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
	public void testBinarySearch1() {
		BinarySearch binarySearch =new BinarySearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=77;
		int isFound=binarySearch.binarySearch(inputArray, searchNumber, 0, inputArray.length-1);
		assertEquals(6, isFound);//No is found at 6th index
	}
	@Test
	public void testBinarySearch2() {
		BinarySearch binarySearch =new BinarySearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=100;
		int isFound=binarySearch.binarySearch(inputArray, searchNumber, 0, inputArray.length-1);
		assertEquals(-1, isFound);//No is not Found
	}
	@Test
	public void testBinarySearch3() {
		BinarySearch binarySearch =new BinarySearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=1;
		int isFound=binarySearch.binarySearch(inputArray, searchNumber, 0, inputArray.length-1);
		assertEquals(-1, isFound);//No is not found
	}


}
