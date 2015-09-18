package com.metacube.jdbc.session1;

import java.util.List;

public class MainClass
{

	public static void main(String[] args) 
	{
		Helper helper = new Helper();
		String authorName = "Sandeep Sopankar";
		List<BookTitles> listOfTitles =helper.titlesByAuthor(authorName.trim());
		System.out.println("List of Titles of author "+authorName+ " are Following....");
		for(BookTitles  bookTitles: listOfTitles)
		{
			System.out.println("\t"+bookTitles);
		}
		String bookName="AI- A Practicle Approach";
		String memberName ="Girdhari";
		String output="Yes";
		boolean hasIssued =helper.hasBookIssued(bookName, memberName);
		if(!hasIssued)
			output="No";
		System.out.println("\nBook "+bookName+" Issued to "+memberName +" "+output);
		int noOfBooks =helper.deleteBooksSinceIssueNotLastYear();
		System.out.println("\nNo of Books Deleted is since last year "+noOfBooks);
		System.out.println("\nExiting . . .");
	}

}
