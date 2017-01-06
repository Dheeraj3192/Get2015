/**
 * Program to implement Tower of Hanoi Problem 
 * Signature of the method is List<String> towerOfHanoi(String source,String destination,String intermediate,int noOfDisk)
 * **/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*Starting of ToweofHanoi Class*/
public class TowerOfHanoi
{
	int noOfDisk;
	List<String> diskMovementList;
	/*Starting of Main Method*/
	public static void main(String[] args)throws IOException 
	{
		int noOfDisk;
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter no of disc\t");
		noOfDisk=Integer.parseInt(input.readLine());
		if(noOfDisk<=0)
		{
			System.out.println("Please enter valid disk no");
			System.exit(1);
		}
		TowerOfHanoi towerOfHanoi=new TowerOfHanoi(noOfDisk);
		List<String> diskMovementList=towerOfHanoi.towerOfHanoi( "A", "B", "C",noOfDisk);
		for(int index=0;index<diskMovementList.size();index++)
			System.out.println(diskMovementList.get(index));
	}
	/*Ending of Main Method*/
	/*Constructor call*/
	public TowerOfHanoi(int noOfdisks) 
	{
		// TODO Auto-generated constructor stub
		this.noOfDisk=noOfdisks;
		diskMovementList=new ArrayList<String>();
	}
	/*implement Tower of hanoi*/
	List<String> towerOfHanoi(String source,String destination,String intermediate,int noOfDisk)
	{
			int disks=this.noOfDisk-noOfDisk+1;
			if(noOfDisk==1)//base case when only one disk is left 			
			{
				String content="Move Disk "+disks+" from "+source+" to "+destination;
				diskMovementList.add(content);
				
			}
			else
			{
				towerOfHanoi(source,intermediate, destination,noOfDisk-1 );
				String content="Move Disk "+disks+" from "+source+" to "+destination;
				diskMovementList.add(content);
				towerOfHanoi(intermediate,destination,source,noOfDisk-1);
				
			}
			return diskMovementList;
		
	}
	
}
/*Ending of ToweofHanoi Class*/
