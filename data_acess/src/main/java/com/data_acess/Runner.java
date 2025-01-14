package com.data_acess;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

	public static void main(String[] args) throws SQLException {
		
		DriverManager.registerDriver(new org.h2.Driver());
		
		try(Connection conn = DriverManager.getConnection("jdbc:h2:file:/Users/rickstermuyco/h2/dataBasePractice;AUTO_SERVER=TRUE","sa","test");
				
				Statement stmt =conn.createStatement()){
			
			
			String insertString = "INSERT INTO gift_list (ID, name, gift, price)" +
					"VALUES(nextval('gift_list_seq'), ?, ? , ? )";
			PreparedStatement insertStmt = conn.prepareStatement(insertString);
			
			String ddl = "DROP TABLE IF EXISTS gift_list";
			stmt.execute(ddl);
			
			ddl = "CREATE TABLE gift_list (" + "ID NUMBER(4) CONSTRAINT gift_list_pk PRIMARY KEY," 
			+ "name VARCHAR2(15)," + "gift VARCHAR2(15),"
			+ "price NUMBER(5));";
			stmt.execute(ddl);
			
			
			
			//Creating sequence
			
			ddl ="DROP SEQUENCE IF EXISTS gift_list_seq";
			stmt.execute(ddl);
			
			ddl = "CREATE SEQUENCE gift_list_seq INCREMENT BY 1 START WITH 1000";			
			stmt.execute(ddl);
			
			int rowsChanged = 0;
			String dml = "INSERT INTO gift_list (ID,name,gift,price)" +
			"VALUES(nextval('gift_list_seq'), 'Audrey', 'VolleyBall', 65)";
			stmt.executeUpdate(dml);
			rowsChanged++;
			
			dml = "INSERT INTO gift_list (ID,name,gift,price)" +
					"VALUES(nextval('gift_list_seq'), 'John', 'BasketBall', 55)";
			stmt.executeUpdate(dml);
			rowsChanged++;
			
			
			insertStmt.setString(1, "Myron");
			insertStmt.setString(2, "Xbox");
			insertStmt.setInt(3, 400);
			insertStmt.executeUpdate();
			
			// Batching running a series of SQL statements simultaneously
			conn.setAutoCommit(false); // Needed before batch 
			
			insertStmt.setString(1, "Claudette");
			insertStmt.setString(2, "Hiking boots");
			insertStmt.setInt(3, 400);
			insertStmt.addBatch();
			
			insertStmt.setString(1, "Brian");
			insertStmt.setString(2, "Rei giftcard");
			insertStmt.setInt(3, 300);
			insertStmt.addBatch();
			
			insertStmt.setString(1, "Krish");
			insertStmt.setString(2, "Pots and Pans");
			insertStmt.setInt(3, 700);
			insertStmt.addBatch();
			
			insertStmt.setString(1, "Ivana");
			insertStmt.setString(2, "Computer");
			insertStmt.setInt(3, 4000);
			insertStmt.addBatch();
			
			insertStmt.executeBatch();
			
			conn.setAutoCommit(true); // returning it back to default
			
			
			// Using newly created DAO object 
			GiftDAO dao = new GiftDAO(conn);
			// creating a gift to send into DAO
			Gift gift = new Gift("SeungKuk****", "Speakers", 200);
			dao.addGift(gift);
			
			
			
			String query = "SELECT id , name, gift,  price FROM gift_list";
			ResultSet rs = stmt.executeQuery(query);
			
			
			while(rs.next()) {
				int personId = rs.getInt("id");
				String personName = rs.getString("name");
				String personGift = rs.getString("gift");
				int giftPrice = rs.getInt("price");
				
			
				System.out.println("ID: " + personId + " Name: " + personName + " gift: "+ personGift + " Price: " +giftPrice );
				
				
			}
			
			
			
			System.out.println("Number of rows Changed: " +  rowsChanged);
		}

	}

}
