package com.acidevil.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {

	
	public static void main(String[] args) {
		try {
			
			String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false&serverTimezone=UTC";
			
			String user  = "root";
			String password = "root";
			
			
			System.out.println("Connecting to database " + jdbcUrl) ;
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, user,password);
			
			System.out.println("Successful");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
}
