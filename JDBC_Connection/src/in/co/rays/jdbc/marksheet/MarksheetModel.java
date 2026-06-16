package in.co.rays.jdbc.marksheet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarksheetModel {
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public int nextPk() throws Exception {
		int pk = 0;
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select max(id) from mark");
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		return pk + 1;

	}

	public void add(MarksheetBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into mark values(?,?,?,?,?,?)");
			pstmt.setInt(1, nextPk());
			pstmt.setInt(2, bean.getRollno());
			pstmt.setString(3, bean.getName());
			pstmt.setInt(4, bean.getPhy());
			pstmt.setInt(5, bean.getChm());
			pstmt.setInt(6, bean.getMaths());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows inserted");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public void update(MarksheetBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn
					.prepareStatement("update mark set rollno = ?, name = ?, phy = ?, chm = ?, maths = ? where id = ?");

			pstmt.setInt(1, bean.getRollno());
			pstmt.setString(2, bean.getName());
			pstmt.setInt(3, bean.getPhy());
			pstmt.setInt(4, bean.getChm());
			pstmt.setInt(5, bean.getMaths());
			pstmt.setInt(6, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows updated");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public void delete(MarksheetBean bean) throws Exception {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from mark where id = ?");
			pstmt.setInt(1, bean.getId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows deleted");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public MarksheetBean findByRollno(int roll) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select * from mark where rollno = ?");
		pstmt.setInt(1, roll);
		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		conn.close();
		pstmt.close();

		return bean;
	}

	public MarksheetBean findByPk(int pk) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		PreparedStatement pstmt = conn.prepareStatement("select * from mark where id = ?");
		pstmt.setInt(1, pk);
		ResultSet rs = pstmt.executeQuery();
		MarksheetBean bean = null;
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
		}
		conn.close();
		pstmt.close();

		return bean;
	}
	
	public List search(MarksheetBean bean) throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		StringBuffer sb = new StringBuffer("select * from mark where 1=1");
		
		if (bean != null) {
			if (bean.getName() != null && bean.getName().length() > 0) {
				sb.append(" and name like '" + bean.getName() + "%'");
			}
			if (bean.getId() > 0) {
				sb.append(" and id = " + bean.getId());
			}
			if (bean.getRollno() > 0) {
				sb.append(" and rollno = " + bean.getRollno());
			}
		}
		System.out.println("SQL -----> " + sb.toString());
		PreparedStatement pstmt = conn.prepareStatement(sb.toString());
		
		ResultSet rs = pstmt.executeQuery();
		List<MarksheetBean> list = new ArrayList<MarksheetBean>();
		
		while(rs.next()) {
			bean = new MarksheetBean();
			bean.setId(rs.getInt(1));
			bean.setRollno(rs.getInt(2));
			bean.setName(rs.getString(3));
			bean.setPhy(rs.getInt(4));
			bean.setChm(rs.getInt(5));
			bean.setMaths(rs.getInt(6));
			list.add(bean);
		}
		conn.close();
		pstmt.close();

		return list;
	}
	
}
