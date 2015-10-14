package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connutil.ConnectionUtil;

import java.sql.*;

@WebServlet("/signup")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public signup() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String username, password, email;
		username = request.getParameter("username").toString();
		password = request.getParameter("password").toString();
		email = request.getParameter("email").toString();
		String query = "SELECT * FROM Registration where username = '"
				+ username + "'";
		Connection con = null;
		int isInsert = 0;
		Statement stmt = null;
		ResultSet rs = null;
		con = ConnectionUtil.getConnection(response);
		boolean usernameExist = false;
		out.print("<center><h1>");
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				usernameExist = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (usernameExist) {
			request.setAttribute("a", "User name already exist");
			request.getRequestDispatcher("signup.jsp").forward(request, response);
		} else {
			try {
				query = "INSERT INTO Registration VALUES('" + username + "','"
						+ password + "','" + email + "')";

				try {
					stmt = con.createStatement();
					isInsert = stmt.executeUpdate(query);
					if (isInsert != 0) {
						request.setAttribute("a", "Inserted Successfully Please Login");
						request.getRequestDispatcher("index.jsp").forward(request, response);
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

					} catch (SQLException e) {
						response.sendRedirect("errorPage.jsp");
					}

				}
			} catch (Exception e) {
				out.print("Can't insert");
			}
		}
		out.print("</h1><br><h2><a href='index.jsp'><I>Go to home.........</I></a></h2></center>");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
