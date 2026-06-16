package in.co.rays.jdbc.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestTransaction {
	public static void main(String[] args) throws Exception {
		ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");
		String driver = rb.getString("driver");
		String url = rb.getString("url");
		String username = rb.getString("username");
		String password = rb.getString("password");
		Connection conn = null;
		try {
			Class.forName(driver);

			conn = DriverManager.getConnection(url, username, password);

			conn.setAutoCommit(false);

			Statement stmt = conn.createStatement();

			int i = stmt.executeUpdate(
					"insert into st_user values (7, 'Suresh', 'Yadav', 'suresh@gmail.com', 'suresh123', '2001-01-01')");
			i = stmt.executeUpdate(
					"insert into st_user values (8, 'Gukesh', 'Yadav', 'Gukesh@gmail.com', 'suresh123', '2001-01-01')");
			i = stmt.executeUpdate(
					"insert into st_user values (9, 'Mukesh', 'Yadav', 'Mukesh@gmail.com', 'suresh123', '2001-01-01')");
			conn.commit();
			System.out.println(i + " Records inserted...");

		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

}
