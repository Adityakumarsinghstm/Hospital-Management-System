package com.DB;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBConnect {
   private static Connection conn;

public DBConnect(Connection conn) {
	super();
	this.conn = conn;
}
   public static Connection getConnection()
   {
	   Connection conn= null;
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","aditya");
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	   return conn;
   }
   
}
