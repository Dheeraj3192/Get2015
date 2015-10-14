package com.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connutil.ConnectionUtil;

import java.sql.*;

@WebServlet("/Signin")
public class Signin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signin() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String username, password;
		username = request.getParameter("username").toString();
		password = request.getParameter("password").toString();
		String query = "select * from Registration where username = '"
				+ username + "' and password = '" + password + "'";
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		RequestDispatcher loginunsuccessful = request
				.getRequestDispatcher("index.jsp");
		RequestDispatcher loginsuccessful = request
				.getRequestDispatcher("loginSuccess.jsp");
		con = ConnectionUtil.getConnection(response);
		boolean isAvailable = false;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				isAvailable = true;
				loginsuccessful.forward(request, response);

			}
			if (!isAvailable) {
				request.setAttribute("a", "Either ID or Password is wrong..");
				loginunsuccessful.forward(request, response);
			}
		} catch (SQLException e) {
			response.sendRedirect("errorPage.jsp");
		} finally {
			/* close connection */
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (SQLException e) {
				response.sendRedirect("errorPage.jsp");
			}

		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
