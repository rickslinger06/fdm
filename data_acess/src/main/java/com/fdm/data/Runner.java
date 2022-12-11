package com.fdm.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

	public static void main(String[] args) throws SQLException {
		
		
		final String url = "jdbc:h2:file:/Users/rickstermuyco/h2/UserExcercise;AUTO_SERVER=TRUE";
		final String userName = "sa";
		final String userPass = "test";
		
		
		DriverManager.registerDriver(new org.h2.Driver());
		
		Connection conn = DriverManager.getConnection(url,userName,userPass);
		
		String ddl = "DROP TABLE IF EXISTS users_exercise";
		Statement stmt = conn.createStatement();
		stmt.execute(ddl);
		
		ddl = "CREATE TABLE users_exercise (" + "ID NUMBER(4) CONSTRAINT gift_list_pk PRIMARY KEY," 
				+ "	username VARCHAR2(15));";
		stmt.execute(ddl);
		
		
	
		
		
		

		
	}

}
