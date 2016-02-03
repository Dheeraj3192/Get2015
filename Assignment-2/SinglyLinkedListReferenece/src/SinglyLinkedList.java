/**
 *Program to perform Linked List Operation  
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SinglyLinkedList {
	
	public void createList(SinglyNode start){
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		int data;
		String choice = null;
		SinglyNode head = null;
		SinglyNode newNode = null;
		do
		{
			System.out.print("Enter value of node");
			data = readData(bufferedReader);
			if(start.getData() == 0) 
			{
				start.setData(data);
				head = start;
			}
			else 
			{
				newNode  =new SinglyNode(data);
				head.setNextNode(newNode);
				head = newNode;
			}
			System.out.print("Do you want to add more nodes:(Y/N) ");
			try 
			{
				choice = bufferedReader.readLine();
			}
			catch(IOException io)
			{
				System.out.println("Error occured please enter again");
			}

		} while (choice.equalsIgnoreCase("y"));
	}
	
	void printList(SinglyNode start)
	{			
		if(start == null) 
		{
			System.out.println("List is Empty");
			return;
		}
		System.out.println("List is :");
		while(start!= null) 
		{
			System.out.println(start.getData());
			start = start.getNextNode();
		}
		System.out.println();
	}
	
	public void addElement(SinglyNode start, int element ) 
	{
		SinglyNode newNode = new SinglyNode(element) ;
		SinglyNode current ;
		
		if(start == null) 
		{
			start = newNode;
		} 
		else 
		{
			current = start;
			while(current.getNextNode() != null) 
			{
				current = current.getNextNode();
			}
			current.setNextNode(newNode);
		}
	}
	
	public SinglyNode insertInBetween(SinglyNode start, int position, int value)
	{
		SinglyNode newNode = new SinglyNode(value);
		SinglyNode current;
		int count = 2;
		current = start ;
		if( position == 1 ) 
		{
			newNode.setNextNode(current);
			start = newNode;
		} 
		else 
		{
			while(count++ != position) {
				current =  current.getNextNode() ;
			}
				newNode.setNextNode(current.getNextNode()); 
				current.setNextNode(newNode); 
			}
		return start;
	}
	
	public void insertAtEnd(SinglyNode start, int value) 
	{
		SinglyNode current = start;
		SinglyNode newNode = new SinglyNode(value);
		while(current.getNextNode() != null) {
			current = current.getNextNode() ;
		}
		current.setNextNode(newNode);
		newNode.setNextNode(null);
	}
	
	int getElement(SinglyNode start, int index) 
	{		
		int count = 0;
		SinglyNode current = start ;
		while( count != index) {
			current = current.getNextNode();
			count++;
		}
		return current.getData();
	}
	
	public void reverseList(SinglyNode start) 
	{
		if(start == null)
		{
			System.out.println("Empty List");
			return ;
		}
		SinglyNode previousNode=null,nextNode=null;
		SinglyNode head=start;
		while(head!=null) 
		{
			nextNode=head.getNextNode();
			head.setNextNode(previousNode);
			previousNode=head;
			head=nextNode;
			
		}
		System.out.println("List is Reversed");
		start = previousNode;
		
	}
	
	public void deleteElementByValue(SinglyNode start, int value) 
	{
		SinglyNode current = start;
		while( current.getNextNode().getData() != value && current.getNextNode().getNextNode() != null ) 
		{
			current = current.getNextNode();
		}
		if(current.getNextNode().getNextNode() == null) System.out.println("Number Doesn't exist!!");
		else if(current.getNextNode() == null)
			current.setNextNode(null) ;
		else
			current.setNextNode(current.getNextNode().getNextNode());
	}
	
	public void deleteElementByIndex(SinglyNode start, int index) 
	{
		SinglyNode current = start;
		int count = 1;
		while( ++count != index ) 
		{
			if(current.getNextNode() == null)
			{
				System.out.println("Index is not valid");
				break;
			}
			current = current.getNextNode();
		}
		if(current.getNextNode() == null)
			current.setNextNode(null) ;
		else {
			SinglyNode nextNode = current.getNextNode().getNextNode();
			current.setNextNode(nextNode);
		}
	}
	
	public int readData(BufferedReader br)
	{
		int data=0;
		boolean isCorrect=false;
		do
		{
			try 
			{
				data =Integer.parseInt(br.readLine());
			}
			catch(NumberFormatException nf)
			{
				System.out.println("Please enter no like 1 2 ");
				continue;
			}
			catch(IOException io)
			{
				System.out.println("Error Occured please enter again");
				continue;
			}
			isCorrect=true;
			
		}while(!isCorrect);
		return data;
	}
	public void sortList(SinglyNode start)
	{
		SinglyNode outer,inner,temp;
		outer=start;
		inner=null;
		temp=start;
		while(outer.getNextNode()!=null)
		{
			temp=start;
			while(temp.getNextNode()!=inner)
			{
				if(temp.getData()>temp.getNextNode().getData())
				{
					temp.setData(temp.getData()+temp.getNextNode().getData());
					temp.getNextNode().setData(temp.getData()-temp.getNextNode().getData());
					temp.setData(temp.getData()-temp.getNextNode().getData());
				}
				temp=temp.getNextNode();
			}
			inner=temp;
			outer=outer.getNextNode();
		}
	}
}
