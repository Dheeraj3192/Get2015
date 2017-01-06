import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestNQuenes {

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
		
		NQuenes nQueens =new NQuenes();
		boolean board[][]=nQueens.solveNQueens(4);
		//we are assuming that false is for 0 and true is for 1
		boolean expected[][]={{false,false,true,false},{true,false,false,false},{false,false,false,true},{false,true,false,	false}};
		boolean isEqual= isBoardEqual(board,expected);
		int check=0;
		if(isEqual)
			check=1;
		assertEquals(1, check);
	}
	public boolean isBoardEqual(boolean board[][],boolean expected[][])
	{
		for(int row=0;row<board.length;row++)
		{
			for(int column=0;column<board[row].length;column++)
			{
				if((board[row][column])!=board[row][column])
				{
					return false;
				}
			}
		}
		return true;
	}

}
