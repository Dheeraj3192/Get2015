/**
 * @author Dheeraj
 * Program to find the Greatest Common Divisor of two number 
 * Signature of the function is int gcd(int number1, int number2) where number1 > 0 and number2 > 0, 
*/
/*Starting of GreatestCommomDivisor Class*/
public class GreatestCommonDivisor {
	/*Starting of main method*/
	public static void main(String args[])
	{
		GreatestCommonDivisor greatestCommonDivisor =new GreatestCommonDivisor();//create instance of GreatestCommonDivisor Class 
		int output=greatestCommonDivisor.gcd(2, 1);
		System.out.println("GCD is"+output);
		
	
	}
	/*Ending of main method*/
	/*Calculate Greatest Common Divisor of two numbers using gcd method*/
	int gcd(int number1, int number2)
	{
		return (number2==0)?number1:gcd(number2,number1%number2);
	}

}
/*Ending  of GreatestCommomDivisor Class*/
