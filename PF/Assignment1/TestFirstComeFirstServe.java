package FirstComeFirstServe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestFirstComeFirstServe {

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
	public void test() {
		 int ArrivalTime[] ={1, 5, 9, 25};
		 int jobLength[]={12,7,2,5};
		 FirstComeFirstServe assign=new FirstComeFirstServe();
		 int output[][]= assign.FCFS(ArrivalTime, jobLength);
		 int expected[][]={{1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29}};
		 int  answer=0;
		 boolean out=isArrayEqual(expected,output);
		 if(out)
			 answer=1;
		 assertEquals(1, answer);
	 }
		
		
	boolean  isArrayEqual(int expected[][],int output[][])
	{
		boolean isArrayEqual=false;
		for(int row=0;row<expected.length;row++)
		{
			for(int column=0;column<expected[row].length;column++)
			{
				if(expected[row][column]!=output[row][column])
				{
					isArrayEqual=true;
					return isArrayEqual;
					
				}
			}
		}
		return isArrayEqual;
	}
	

}
