package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JDBCDemo {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";
	// jdbc:driver type:hostname:port/db name
	String dbUrl = "jdbc:mysql://166.62.36.207:3306/syntaxhrm_mysql";

	//@Test
	public void abc() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("Db connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from hs_hr_employees;");
		rs.next();
		String firstname = rs.getString("emp_firstname");
		System.out.println(firstname);
	
		rs.next();
		String firstname2 = rs.getObject("emp_firstname").toString();// if you dont know it is string or int then use
																		// object it will pring both string and int
		System.out.println(firstname2);

		String allData;
		while (rs.next()) {
			allData = rs.getObject("emp_firstname").toString();
			System.out.println(allData);
		}
		
		
		rs.close();
		st.close();
		conn.close();

	}
	
	// retrieve all the job titles and store them in arrylist and show it in a consol
	
	@Test
	public void jobtitle() throws SQLException {
		Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		System.out.println("Db connection is successful");
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select job_title from ohrm_job_title");
		
//		String Alldata;
//		while(rs.next()){
//			Alldata=rs.getObject("job_title").toString();
//			System.out.println(Alldata);
//		}
		
		List <String>jobTitles=new ArrayList<String>();
		while (rs.next()) {
			jobTitles.add(rs.getObject("job_title").toString());
		}
		System.out.println(jobTitles);
		for(String jt:jobTitles) {
			System.out.println(jt);
		}
	}
}
