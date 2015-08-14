import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Dheeraj
 *Program to Solve the N queens problem where N>1
 */
/*Starting of NQueens Class*/
public class NQuenes {
	
	/*Starting of main method*/
	public static void main(String[] args)throws IOException
	{
		NQuenes nQueens =new NQuenes();
		int noOfQueens;
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no of Queens\t");
		noOfQueens=Integer.parseInt(input.readLine());
		boolean board[][]=nQueens.solveNQueens(noOfQueens);
		for(int row=0;row<board.length;row++)
		{
			int isTrue=0;
			for(int col=0;col<board[row].length;col++)
			{
				if(board[row][col])
					isTrue=1;
				System.out.print(isTrue+"\t");
				isTrue=0;
			}
			System.out.println();
		}
	}
	/*Ending of main method*/
	
	/*Printing the solution*/
	boolean[][] getBoard(boolean board[][])
	{
		
		return board;
	   
	}
	/*Check that queens place is safe at all direction*/
	boolean isSafe(boolean board[][], int row, int column)
	{
	 
		/* Check the row on left side */
	    for (int index = 0; index < column; index++)
	    {
	        if (board[row][index])
	            return false;
	    }
	 
	    /* Check upper diagonal left side */
	    for (int index1 = row, index2 = column; index1 >= 0 && index2 >= 0; index1--, index2--)
	    {
	        if (board[index1][index2])
	            return false;
	    }
	    /* Check lower  diagonal on left side */
	    for (int index1 = row, index2 = column; index2 >= 0 && index1 < board.length; index1++, index2--)
	    {
	        if (board[index1][index2])
	            return false;
	    }
	    /*if the queen is safe */
	    return true;

	}
	boolean solveNQueenProblem(boolean board[][], int column)
	{
	    /*  If all queens are placed then return true */
	    if (column >= board.length)
	        return true;
	 
	    /* Consider this column and try place queen in all rows
	       one by one */
	    for (int index = 0; index < board.length; index++)
	    {
	        /* Check if queen can be placed on board[i][column] */
	        if ( isSafe(board, index, column) )
	        {
	            /* Place this queen in board[i][column] */
	            board[index][column] = true;
	 
	            /*Place rest of the queen */
	            if ( solveNQueenProblem(board, column + 1) == true )
	                return true;
	 
	            /* If placing queen in board[i][column] then remove queen from board[i][column] */
	            board[index][column] = false; // Backtracking
	        }
	    }
	 
	     /* If queen can not be place then return false */
	    return false;
	}
	/*Starting of the NQueens problem */
	boolean[][] solveNQueens(int noOfQueens)
	{
	    boolean board[][] = new boolean[noOfQueens][noOfQueens];
	    if ( solveNQueenProblem(board, 0) == false )
	    {
	      System.out.println("Solution does not exist");
	      System.exit(1);
	    }
	    return board;
	}
	
}
/*Ending of NQueens Class*/	 

 

   

 
   
   



