package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestCreate {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/full_sql","root","root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("create table mongo( id int,type varchar(35) )");

		System.out.println(i + " Table Created");
		
		stmt.close();
		conn.close();
	}
}
