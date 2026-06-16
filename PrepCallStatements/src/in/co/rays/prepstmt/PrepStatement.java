package in.co.rays.prepstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class PrepStatement {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/full_sql","root","root");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");
		while (rs.next()) {
			System.out.println("ID : " + rs.getInt(1) );
		}
		stmt.close();
		conn.close();
	}
}
