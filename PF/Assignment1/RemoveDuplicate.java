package RemoveDuplicate;
class RemoveDuplicate
{
	int[] removeDuplicate(int input[])
	{
		int index=0,inputSize;
		boolean isduplicate=false;
		inputSize = input.length;
		int reducedArray[] = new int[inputSize];
		for(int count=0; count< inputSize; count++)
		{
			for(int digitArray2=0 ; digitArray2 <= index ; digitArray2++)
			{
				if(reducedArray[digitArray2]==input[count])
				{
					isduplicate=true;
					break;
				}
			}
			if(!isduplicate)
			{
				reducedArray[index++]= input[count];
			}
		}
		return reducedArray;
	}
	public static void main(String args[])throws Exception
	{  
  		RemoveDuplicate rd=new RemoveDuplicate();
  		int array[] ={2,5,4,6,3,8,5,9,3,3,6,3,9,0};
		int reducedArray[] = rd.removeDuplicate(array);
		for(index=0;index<reducedArray.length;index++)
			System.out.println(reduced[index]);
 	}  
} 
