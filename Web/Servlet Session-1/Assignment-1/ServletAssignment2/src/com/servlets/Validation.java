package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Validation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Validation() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String input = "";
		String output = "";
		try {
			if (!isValid(input = request.getParameter("FirstName"), 3, 20))
				output += "First name is invalid should range 3 to 20<br>";
			if (!isValid(input = request.getParameter("LastName"), 3, 20))
				output += "Last name is invalid should range 3 to 20<br>";
			if (!isValid(input = request.getParameter("Password"), 8, 15))
				output += "Password is Empty or invalid should range 8 to 15<br>";
			if (!(request.getParameter("Confirm").equals(input)))
				output += "Password is mismatch<br>";
			if (!isValidAge(request.getParameter("Age")))
				output += "Age is invalid<br>";
			if (request.getParameter("State").equals("Select State"))
				output += "Invalid state<br>";
			if (request.getParameter("City").equals("Select City"))
				output += "Invalid City<br>";
			if (!isValid(input = request.getParameter("Address"), 20, 50))
				output += "Address should range in 20 to 50<br>";
			if (output.equals(""))
				output = "Form Submit Successfully<br>";
		} catch (NullPointerException np) {
			output="Field has been removed";
		}
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("DisplayOutput");
		request.setAttribute("output", output);
		requestDispatcher.forward(request, response);
		//out.print(output);
		out.close();
	}

	private boolean isValid(String input, int min, int max) {

		input = input.trim();
		if (input.length() < min || input.length() > max)
			return false;
		return true;
	}

	private boolean isValidAge(String input) {
		int age = 0;
		try {
			age = Integer.parseInt(input.trim());
		} catch (NumberFormatException nf) {
			return false;
		}
		if (age < 18 || age > 100)
			return false;

		return true;
	}

}
