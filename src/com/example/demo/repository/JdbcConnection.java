package com.example.demo.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
	
	static final String DB_URL = "jdbc:mysql://localhost/HospitalManagement";
	static final String USER = "admin";
	static final String PASS = "admin";

	public static Connection establishConnection() throws SQLException {
		return  DriverManager.getConnection(DB_URL, USER, PASS);
		
	}
}
