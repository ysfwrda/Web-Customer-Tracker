package com.abouwarda.testdb;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class TestDbServlet
 */
@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set up connection variables
		String user ="springstudent";
		String pass = "springstudent";
		
		String jdbcurl="jdbc:mysql://localhost:3306/web_customer_tracker?useSSL=false&serverTimezone=UTC";
		String drvier = "com.mysql.cj.jdbc.Driver";
		// get a connection to the database
		try {
			PrintWriter out = response.getWriter();
			out.println("Connecting to database: "+ jdbcurl);
			Class.forName(drvier);
			Connection myConn = DriverManager.getConnection(jdbcurl,user,pass);
			out.println("SUCESS");
			myConn.close();
		}
		catch(Exception exc) {
		exc.printStackTrace();
		}
	}

}
