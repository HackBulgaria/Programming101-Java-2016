package sql;

import java.sql.*;

public class Main {
	
	static final String DB_URL = "jdbc:mysql://localhost/sqTesting";
	static final String USER = "root";
	static final String PASS = "123";

	public static void main(String[] args) {
		try {
			Connection conn = null;
			Statement stmt = null;
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			
			//STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name, age FROM Clients";
			ResultSet rs = stmt.executeQuery(sql);
			
			//STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String name = rs.getString("name");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", Name: " + name);
		      }
		      //STEP 6: Clean-up environment
		      rs.close();
		      stmt.close();
		      conn.close();
		} catch(Exception se) {
			se.printStackTrace();
		}
	}

}
