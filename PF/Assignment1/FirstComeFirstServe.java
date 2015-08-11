/**
4
 * Program to Schedule the required jobs in First Come First Serve manner
 * Signature used int[][]FCFS(int arrivalTime,int jobLength)
 */
package FirstComeFirstServe;
import java.util.*;
public class FirstComeFirstServe{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FirstComeFirstServe firstComeFirstServe=new FirstComeFirstServe();
		Scanner sc=new Scanner(System.in);
		int noOfJobs;
		System.out.println("Enter No of Jobs: ");
		noOfJobs=sc.nextInt();
		int arrivalTime[]=new int[noOfJobs];
		int jobLength[]=new int[noOfJobs];
		System.out.println("Enter Arrival Times: ");
		for(int index=0;index<arrivalTime.length;index++)
		{
			arrivalTime[index]=sc.nextInt();
		}
		System.out.println("Enter Job Size: ");
		for(int index=0;index<jobLength.length;index++)
		{
			jobLength[index]=sc.nextInt();
		}
		int output[][]=firstComeFirstServe.FCFS(arrivalTime,jobLength);
		System.out.print("job\t"+"job arrived time\t"+"job wait time\t"+"job start at\t"+"job finished at\n");
		for(int row=0;row<arrivalTime.length;row++)
		{
			for(int column=0;column<5;column++)
			{
				System.out.print(output[row][column]+"\t\t");
			}
			System.out.println();
		}
		sc.close();
	}
	
	public int[][] FCFS(int arrivalTime[], int jobLength[])
	{
		int temp;
		int rowLength=arrivalTime.length;
		int jobs[] = new int[rowLength];
		int waitingTime[] = new int[rowLength];
		int jobFinishTime[] =new int[rowLength];
		int jobStartTime[] =new int[rowLength];
		/*For initialize job number like 1,2,3,4 */
		for(int index=0;index<rowLength;index++)
		{
			jobs[index]=index+1;
		}
		/* For Order in ascending of arrivalTime*/
		for(int row=0;row<rowLength;row++)
		{
			for(int column=row;column<rowLength;column++)
			{
				if(arrivalTime[row]>arrivalTime[column])
				{
					temp=arrivalTime[row];
					arrivalTime[row]=arrivalTime[column];
					arrivalTime[column]=temp;
				}
			}
		}
		/*Calculate waiting time*/
		waitingTime[0]=0;
		int size=jobLength[0];
		for(int index=1;index<rowLength;index++)
		{
			waitingTime[index]=size-arrivalTime[index]+1;
			if(waitingTime[index]<0)
			{
				waitingTime[index]=0;
			}
			size+=jobLength[index];
		}
		/*Calculate job finished time*/
		jobFinishTime[0]=jobLength[0]+arrivalTime[0];
		for(int index=1;index<rowLength;index++)
		{
			jobFinishTime[index]=((jobFinishTime[index-1]>arrivalTime[index])?jobFinishTime[index-1]:arrivalTime[index]-1)+jobLength[index];
		}
		jobStartTime[0]=(arrivalTime[0]>1)?arrivalTime[0]:1;
		/*Calculate job Start Time*/
		for(int index=1;index<rowLength;index++)
		{
			jobStartTime[index]=jobStartTime[index-1]+jobLength[index-1];
			jobStartTime[index]=(jobStartTime[index]>=arrivalTime[index])?jobStartTime[index]:arrivalTime[index];
		}
		/*Store the result in 2 dimensional array*/
		int[][] result=new int[rowLength][5];
		for(int index=0;index<rowLength;index++)
		{
			result[index][0]=jobs[index];
			result[index][1]=arrivalTime[index];
			result[index][2]=waitingTime[index];
			result[index][3]=jobStartTime[index];
			result[index][4]=jobFinishTime[index];
		}
		return result;
	}

}
