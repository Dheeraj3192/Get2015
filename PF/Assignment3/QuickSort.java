/**
 *@author Dheeraj
 *Program to sort an array in ascending order by using quick sort 
 *Signature of the method is int[] quickSorting(int inputArray[])
 **/

/*Starting of QuickSort class*/
public class QuickSort {
	/*Starting of main method*/
	public static void main(String args[])
	{
		QuickSort quickSort=new QuickSort();
		int inputArray[]={33,2,1,44,66,23,22,2};
		int lowerIndex=0,higherIndex=inputArray.length-1;
		System.out.println("Before quick sort is");
		for(int index=0;index<inputArray.length;index++)
			System.out.print(inputArray[index]+"\t");
		int afterSorting[]=quickSort.quickSorting(inputArray ,lowerIndex,higherIndex);
		System.out.println("\nAfter quick sort is");
		for(int index=0;index<afterSorting.length;index++)
			System.out.print(afterSorting[index]+"\t");
	}
	/*Ending of main method*/
	/*Perform quick sort using quickSorting method*/
	int[] quickSorting(int inputArray[],int lowerIndex,int higherIndex) 
	{
		if(inputArray==null||inputArray.length==0)// the given input is empty
			return inputArray ;
		
		 if(lowerIndex < higherIndex)
		 {
			  
			  	 int partitionIndex = partition(inputArray, lowerIndex, higherIndex);
			  	 if(lowerIndex<partitionIndex-1)
			  		 quickSorting(inputArray, lowerIndex, partitionIndex - 1);
			  	 if(partitionIndex<higherIndex)
			  		 quickSorting(inputArray, partitionIndex, higherIndex);
		 }
		 	return inputArray;//problem in return statement
	}
	/*partition method divide the array in two parts at every time when calling of partition method*/
	int partition(int inputArray[],int lowerIndex, int higherIndex)
	{
		    int pivotValue =inputArray[(lowerIndex+higherIndex)/2] ;//pivotValue is the element from where array is divide in two parts 
		    int leftIndex=lowerIndex,rightIndex=higherIndex;
		    while(leftIndex<=rightIndex)
		    {
		    	while(inputArray[leftIndex]<pivotValue)
		    		leftIndex++;
		    	while(inputArray[rightIndex]>pivotValue)
		    		rightIndex--;
		    	if(leftIndex<=rightIndex)
		    	{
		    		int temp=inputArray[leftIndex];
		    		inputArray[leftIndex]=inputArray[rightIndex];
		    		inputArray[rightIndex]=temp;
		    		leftIndex++;
		    		rightIndex--;
		    	}
		    	
		    }
		    return leftIndex;
	}
}
/*Ending of QuickSort Class*/
