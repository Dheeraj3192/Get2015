package SortedArray;

public class SortedArray {
	public static void main(String args[])
	{
		SortedArray obj=new SortedArray();
		int a[]={5,4,3,2,1};
		int output=obj.isSorted(a);
		System.out.println("output is "+output);
		
	}
	public  int isSorted(int[] a)
	{
			int flag=0;
		    for(int index = 0; index < a.length-1; index ++){ 

		        if (a[index] < a[index+1])
		            flag=1;
		        else{
		        	flag=0;
		        	break;
		        	}
		        }
		    if(flag==1)
		    	return 1;
		    else {
		    	flag=0;
		    	for(int index = 0; index <a.length-1 ; index ++){ 

		            if (a[index] > a[index+1])
		                flag=1;
		            else{
		            	flag=0;
		            	break;
		            	}
		            }
		    	if(flag==1)
		        	return 2;
		    	else return 0;
			} 
		}



}
