package in.co.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TestUpdate {
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/full_sql", "root", "root");

		Statement stmt = conn.createStatement();

		int i = stmt.executeUpdate("update emp set name = 'ABC' where id = 3");
		// int j = stmt.executeUpdate("alter table mongo add column year varchar(25)");

		int k = stmt.executeUpdate("update mongo set year = '2006' where id = 1");
		int l = stmt.executeUpdate("update mongo set year = '2007' where id = 2");
		System.out.println(i + " rows updated");
		System.out.println(k + " rows updated");
		System.out.println(l + " rows updated");
		// System.out.println(j + " altered table");
		
		stmt.close();
		conn.close();
	}
}
