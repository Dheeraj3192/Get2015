/**
 * @author Dheeraj
 * Program to find a number in an array using Binary Search
 * Signature of the method is int binarySearch(int inputArray[],int searchNumber)
 * */
/*Starting of BinarySearch class*/
public class BinarySearch {
	/*Starting of main method*/
	public static void main(String args[])
	{
		BinarySearch binarySearch =new BinarySearch();
		int inputArray[]={2,5,8,9,10,55,77};
		int searchNumber=77;
		int isFound=binarySearch.binarySearch(inputArray, searchNumber, 0, inputArray.length-1);
		if(isFound==-1)
			System.out.println("No is not found");
		else
			System.out.println("No is found at index "+isFound);
		
	}
	/*Ending of main method*/
	/*Find a number in mehtod binarySearch*/
	int binarySearch(int inputArray[],int searchNumber,int startIndex,int endIndex)
	{
			int middleIndex=(startIndex+endIndex)/2;//Find the index of  middle element
			if(startIndex>endIndex)//if number is not found in an array
				return -1;
			if(inputArray[middleIndex]==searchNumber)//if number is found at middleIndex
				return middleIndex;
			else if(inputArray[middleIndex]>searchNumber)
				return binarySearch(inputArray, searchNumber, startIndex, middleIndex-1);
			else
				return binarySearch(inputArray, searchNumber, middleIndex+1, endIndex);
		
	}
}
/*Ending of BinarySearch class*/
