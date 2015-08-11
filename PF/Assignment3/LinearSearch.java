/**
 * @author Dheeraj
 * Program to find a number in a given sequence of an array using Linear Search
 * Signature of the method is int linearSearch(int inputArray[],int searchNumber,int index)
 * */

/*Starting of LinearSearch Class*/
public class LinearSearch {
	/*Starting of main method */
	public static void main(String args[])
	{
		LinearSearch linearSearch=new LinearSearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=55,index=0;
		int isFound=linearSearch.linearSearch(inputArray, searchNumber, index);
		if(isFound==-1)
			System.out.println("No is not found");
		else
			System.out.println("No is found at index "+isFound);
	}
	/*Ending of main method*/
	/*To Search a given number in an array in method linearSearch*/
	int linearSearch(int inputArray[],int searchNumber,int index)
	{
		if(index==inputArray.length)//number is not found
			return -1;
		else if(inputArray[index]==searchNumber)//if the number is found
			return index;
	
		return linearSearch(inputArray, searchNumber, ++index);
	}
}
/*Starting of LinearSearch Class*/
