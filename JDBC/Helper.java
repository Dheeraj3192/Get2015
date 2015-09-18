package com.metacube.jdbc.session1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

public class Helper {


	public  List<BookTitles> titlesByAuthor(String authorName) { // it return the list of titles by given author name

		String query = "SELECT * FROM titles t WHERE EXISTS (SELECT * FROM title_author ta WHERE ta.title_id = t.title_id AND EXISTS "
				+ "(SELECT * FROM authors a WHERE a.author_id = ta.author_id  AND author_name='"
				+ authorName + "' LIMIT 1))";

		List<BookTitles> listOfBookTitles = new ArrayList<BookTitles>();
		BookTitles bookTitles = null;
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		
		connection = ConnectionUtil.getConnection();
		try {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			if (resultSet == null)
				return null;

			while (resultSet.next()) {
				bookTitles = new BookTitles();
				bookTitles.setTitleId(resultSet.getInt("title_id"));
				bookTitles.setTitleName(resultSet.getString("title_name"));
				listOfBookTitles.add(bookTitles);
			}
			
			return listOfBookTitles;
			
		} catch (SQLException e) {
			System.out.println("SQL Exception Occured");
			return null;

		} finally {
			/* close connection */
			try {
				connection.close();
				statement.close();
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("SQL Exception Occured");
				return null;
			}
		}

	}
	
	public boolean hasBookIssued (String bookName , String memberName)
	{
		String query = "select * from book_issue where member_id = (select member_id  from members where member_name = ?)"
				+ "and accession_no=(select accession_no from books b,titles t where t.title_id = b.title_id and title_name= ? and b.status =?)";

		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		
		connection = ConnectionUtil.getConnection();
		try {
			preparedStatement = (PreparedStatement) connection.prepareStatement(query);
			preparedStatement.setString(1, memberName);
			preparedStatement.setString(2, bookName);
			preparedStatement.setString(3,"N");
			resultSet = preparedStatement.executeQuery();
			if (resultSet == null)
				return false;
			int count=0;
			while (resultSet.next()) {
				count++;
			}
			if(count==0)
				return false;
			return true;
			
			
		} catch (SQLException e) {
			System.out.println("SQL Exception Occured");
			return false;

		} finally {
			/* close connection */
			try {
				connection.close();
				preparedStatement.close();
				resultSet.close();
			} catch (SQLException e) {
				System.out.println("SQL Exception Occured");
				return false;
			}
		}

	}
	
	
	
	public  int deleteBooksSinceIssueNotLastYear() { // it return the no of books deleted

			String query = "Delete FROM books WHERE DATEDIFF(NOW(),purchase_date) > 365 AND "
					+ "accession_no NOT IN (SELECT DISTINCT(accession_no) FROM book_issue WHERE DATEDIFF( NOW(),issue_date) <= 365)"; 

			Connection connection = null;
			Statement statement = null;
			int noOfRows=0;
			connection = ConnectionUtil.getConnection();
			try 
			{
				if(connection!=null)
				{
					statement = connection.createStatement();
					noOfRows = statement.executeUpdate(query);
				}
				return noOfRows ;
			}
			catch (SQLException e) {
				System.out.println("SQL Exception Occured");
				return -1;

			} finally {
				/* close connection */
				try {
					connection.close();
					statement.close();
				} catch (SQLException e) {
					System.out.println("SQL Exception Occured");
					return -1;
				}
			}

		}
}
