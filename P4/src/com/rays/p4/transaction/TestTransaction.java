package com.rays.p4.transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTransaction {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/full_sql", "root", "root");

			conn.setAutoCommit(true);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values(5, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-01')");

			i = stmt.executeUpdate(
					"insert into st_user values(6, 'Suresh', 'Yadav', 'suresh@gmail.com', 'sur','2001-01-01')");

			i = stmt.executeUpdate(
					"insert into st_user values(5, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-01')");

//			conn.commit();
			System.out.println("transaction coplited:(records saved)");

			conn.close();
			stmt.close();

		} catch (Exception e) {
//			conn.rollback();
			e.printStackTrace();
		}

	}

}
