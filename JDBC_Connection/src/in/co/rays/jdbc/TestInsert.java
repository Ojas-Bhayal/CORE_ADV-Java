package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestInsert {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/full_sql","root","root");
		
		Statement stmt = conn.createStatement();
		
		int i = stmt.executeUpdate("insert into mongo values(1,'Compass'),(2,'Atlas')");
		
		System.out.println(i + " rows inserted");
		
		stmt.close();
		conn.close();
		
	}
}
