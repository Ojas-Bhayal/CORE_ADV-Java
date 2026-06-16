package in.co.rays.hostel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HostelModel {

	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.app");

	String driver = rb.getString("driver");
	String url = rb.getString("url");
	String username = rb.getString("username");
	String password = rb.getString("password");

	public int nextPk() throws Exception {

		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		int pk = 0;

		PreparedStatement pstmt = conn.prepareStatement("select max(roomId) from hostel_model");

		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);
		}
		conn.close();
		pstmt.close();
		
		return pk + 1;
	}

	public void add(HostelBean bean) throws Exception {
		Class.forName(driver);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("insert into hostel_model values (?,?,?,?,?)");

			pstmt.setInt(1, bean.getRoomId());
			pstmt.setString(2, bean.getStudentName());
			pstmt.setString(3, bean.getRoomType());
			pstmt.setDouble(4, bean.getFee());
			pstmt.setString(5, bean.getBlockName());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows affected(rows inserted...)");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public void update(HostelBean bean) throws Exception {
		Class.forName(driver);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(
					"update hostel_model set studentName = ?, roomType = ?, fee = ?, blockName = ? where roomId = ?");

			pstmt.setString(1, bean.getStudentName());
			pstmt.setString(2, bean.getRoomType());
			pstmt.setDouble(3, bean.getFee());
			pstmt.setString(4, bean.getBlockName());
			pstmt.setInt(5, bean.getRoomId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows affected(rows updated...)");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public void delete(HostelBean bean) throws Exception {
		Class.forName(driver);
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement("delete from hostel_model where roomId = ?");

			pstmt.setInt(1, bean.getRoomId());

			int i = pstmt.executeUpdate();
			System.out.println(i + " rows affected(rows deleted...)");
			conn.commit();
			conn.close();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
	}

	public List<HostelBean> search(HostelBean bean) throws Exception {
		Class.forName(driver);
		Connection conn = null;
		List<HostelBean> list = new ArrayList<HostelBean>();
		try {
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			StringBuffer sb = new StringBuffer("select * from hostel_model where 1=1");
			if (bean != null) {
				if (bean.getRoomId() > 0) {
					sb.append(" and roomId = " + bean.getRoomId());
				}
				if (bean.getStudentName() != null && bean.getStudentName().length() > 0) {
					sb.append(" and studentName like '" + bean.getStudentName() + "%'");
				}
				if (bean.getRoomType() != null && bean.getRoomType().length() > 0) {
					sb.append(" and roomType like '" + bean.getRoomType() + "%'");
				}
				if (bean.getBlockName() != null && bean.getBlockName().length() > 0) {
					sb.append(" and blockName like '" + bean.getBlockName() + "%'");
				}
			}
			System.out.println("SQL Command ------> " + sb.toString());

			PreparedStatement pstmt = conn.prepareStatement(sb.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				bean = new HostelBean();
				bean.setRoomId(rs.getInt(1));
				bean.setStudentName(rs.getString(2));
				bean.setRoomType(rs.getString(3));
				bean.setFee(rs.getDouble(4));
				bean.setBlockName(rs.getString(5));
				list.add(bean);
			}
			conn.commit();
			pstmt.close();
		} catch (Exception e) {
			conn.rollback();
			e.printStackTrace();
		}
		conn.close();
		
		return list;

	}
}
