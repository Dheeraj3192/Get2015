/**
 * @author Dheeraj
 * Program to find the largest digit in the given number
 * Signature of the method is int largestDigit(int number) where number>=0
 * */

/*Starting of LargestDigit Class*/
public class LargestDigit {
	/*Starting of main method*/
	public static void main(String args[])
	{
		LargestDigit largestDigit=new LargestDigit();
		int output=largestDigit.largestDigit(12391);
		System.out.println("largest digit in 12391 is "+output);
		
	}
	/*Ending of main method*/
	/*Find the largest Digit by latgestDigit method*/
	int largestDigit(int number)
	{
		
			if(number< 10 )			//if number is less thean ten so number is the largest one
				return number;
			return ( number % 10) > largestDigit( number / 10 ) ? (number % 10): largestDigit( number / 10 ) ;
				//check if number % 10 is greater or returned value of largestDigit function is greater and 
				//perform actions accordingly
	}	
}
/*Ending of LargestDigit Class*/
