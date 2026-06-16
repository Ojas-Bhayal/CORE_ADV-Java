package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnection {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/full_sql","root","root");
		
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("select * from mongo");
		
		while(rs.next()) {
			System.out.println("ID : "+ rs.getInt(1));
			System.out.println("Name : "+ rs.getString(2));
			System.out.println("Year : "+ rs.getString(3));
		}
		
		stmt.close();
		conn.close();
	}
}
