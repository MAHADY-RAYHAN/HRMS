package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";
	
	//@Test
	public void dbMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		DatabaseMetaData dbMetaData = conn.getMetaData();
		String driverName = dbMetaData.getDriverName();
		String dbVersion = dbMetaData.getDatabaseProductVersion();
		System.out.println(driverName);
		System.out.println(dbVersion);
		
	}
	// query - display all the info about employee whos emp_number is 14688
	@Test
	public void rsMetadata() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		Statement st = conn.createStatement();
		ResultSet rs=st.executeQuery("select * from hs_hr_employees where emp_number = 14688");
		ResultSetMetaData rsMetadata = rs.getMetaData();
		int colNumbers=rsMetadata.getColumnCount();
		System.out.println(colNumbers);
		String conName1 = rsMetadata.getColumnName(1);
		System.out.println(conName1);
		
		for(int i = 1; i<= colNumbers; i++) {
			String conNames = rsMetadata.getColumnName(i);
			System.out.println(conNames);
		}
		
		 // hw get the resultset metadata store it in the arraylist and retrieve it from arraylist 
		// also get column type name get the table names
	}
}
