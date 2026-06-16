package in.co.rays.jdbc.preparedstatement;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {

		// testnextPk();
		// testadd();
		// testupdate();
		// testdelete();
		// testfindbyLogin();
		// testfindbyPk();
		// testAuth();
		testSearch();

	}

	private static void testSearch() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		//bean.setFirstName("o");
		//bean.setLastName("Mittal");
		//bean.setId(2);
		//bean.setLogin("s");
		bean.setDob(sdf.parse("2006-06-13"));
		List<UserBean> list = model.search(bean);
		Iterator<UserBean> it = list.iterator();

		while (it.hasNext()) {
			bean = it.next();
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
			System.out.println("--------------");
		}

	}

	private static void testAuth() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.authenticate("om@gmail.com", "om");
		if (bean == null) {
			System.out.println("User Not Found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	private static void testfindbyPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByPk(2);
		if (bean == null) {
			System.out.println("User Not Found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	private static void testfindbyLogin() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean = model.findByLogin("om@gmail.com");
		if (bean == null) {
			System.out.println("User Not Found");
		} else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}

	}

	private static void testdelete() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(2);
		model.delete(bean);
	}

	private static void testupdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean.setId(1);
		bean.setFirstName("Raghav");
		bean.setLastName("Sahu");
		bean.setLogin("rs@gmail.com");
		bean.setPassword("rs123");
		bean.setDob(sdf.parse("2006-04-13"));

		model.update(bean);

	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		bean.setFirstName("Suraj");
		bean.setLastName("Sahu");
		bean.setLogin("suraj@gmail.com");
		bean.setPassword("suraj123");
		bean.setDob(sdf.parse("2006-06-13"));
		model.add(bean);

	}

	private static void testnextPk() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();

		int i = model.nextPk();

		System.out.println(" Next Primary Key " + i);
	}

}
