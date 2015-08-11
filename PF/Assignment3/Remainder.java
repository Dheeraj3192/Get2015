/**
 *@author Dheeraj
 *Program to find the remainder of two number 
 *Signature of the function is int rem(int number1,int number2) where number1>=0 and number2>0
 */
/*Starting of Remainder class*/
public class Remainder
{
	/*Starting of main function*/
	public static void main(String args[])
	{
		Remainder remainder =new Remainder();
		int output=remainder.rem(5, 8);
		System.out.println(output);
		
	}
	/*Ending of main function*/
	
	/*rem method to calculate remainder of two numbers*/
	int rem(int number1 ,int number2)
	{
		
		if(number1<0 || number2<=0)//number1 and number2 are negative 
			return -1;
		
		return (number1<number2)?number1:rem(number1-number2,number2);//Otherwise   	
	}
}
/*Ending of Remainder class*/
