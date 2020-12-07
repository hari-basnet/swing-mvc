package com.swingdemo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	 public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	 public static final String DATABASE_URL = "jdbc:mysql://localhost:3306/swing_mvc";
	 public static final String DATABASE_USER = "root";
	 public static final String DATABASE_PASSWORD = "";

	public static Connection createConnection() {
		
		try {
			Class.forName(DRIVER_NAME);
			return DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
