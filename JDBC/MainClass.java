package com.metacube.jdbc.session1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class MainClass
{

	public static void main(String[] args) 
	{
		Helper helper = new Helper();
		System.out.println("Enter author name");
		String authorName =getString();
		List<BookTitles> listOfTitles =helper.titlesByAuthor(authorName.trim());
		if(listOfTitles.size()==0)
			System.out.println("No  record available");
		else {
			System.out.println("List of Titles of author "+authorName+ " are Following....");
			for(BookTitles  bookTitles: listOfTitles)
				System.out.println("\t"+bookTitles);
		}
		System.out.println("Enter book name");	
		String bookName=getString();
		System.out.println("Enter name who book issue");
		String memberName =getString();
		boolean hasIssued =helper.hasBookIssued(bookName, memberName);
		if(!hasIssued)
			System.out.println("No record available");
		else 
			System.out.println("\nBook "+bookName+" Issued to "+memberName );
		int noOfBooks =helper.deleteBooksSinceIssueNotLastYear();
		System.out.println("\nNo of Books Deleted is since last year "+noOfBooks);
		System.out.println("\nExiting . . .");
	}

	
	
	public static String getString () {
		String input="";
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		do {
			try {
				input = bufferedReader.readLine().trim();
				
			}
			catch(IOException io) {
				System.out.println("Please enter input again ");
				continue;
			}
			if(input.equals("")) {
				System.out.println("Please enter valid input");
				continue;
			}
			break;
		}while(true);
		
		return input;
	}
}
