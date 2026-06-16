package com.rays.p4;

import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

public class TestUserModel {
	public static void main(String[] args) throws Exception {
//		testnextPk();
//		testadd();
//		testupdate();
//		testdelete();
//		testfinByLogin();
//		testAuth();
		testSearch();

	}

	private static void testAuth() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		
		  bean= model.authenticate("suraj@gmail.com", "suraj123");
		  
			if (bean == null) {
				 System.out.println("User Not Found...");
				
			}
			else {
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
			}
		  
	}

	private static void testfinByLogin() throws Exception {
		UserModel model = new UserModel();
		UserBean bean = new UserBean();
		bean = model.findByLogin("suraj@gmail.com");
		
		if (bean == null) {
			 System.out.println("User Not Found...");
			
		}
		else {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstName());
			System.out.println(bean.getLastName());
			System.out.println(bean.getLogin());
			System.out.println(bean.getPassword());
			System.out.println(bean.getDob());
		}
	}

	private static void testdelete() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean.setId(1);
		model.delete(bean);

	}

	private static void testupdate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean.setId(1);
		bean.setFirstName("Krish");
		bean.setLastName("Mittal");
		bean.setLogin("km@gmail.com");
		bean.setPassword("km");
		bean.setDob(sdf.parse("2020-12-12"));
		model.add(bean);

	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();
		bean.setFirstName("Ojas");
		bean.setLastName("Mittal");
		bean.setLogin("Om@gmail.com");
		bean.setPassword("om");
		bean.setDob(sdf.parse("2020-12-12"));
		model.add(bean);

	}

	private static void testnextPk() throws Exception {
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		int i = model.nextPk();
		System.out.println("Next Primary key : " + i);

	}
	
	public static void testSearch() throws Exception {

		UserModel model = new UserModel();
		UserBean bean = new UserBean();

//		bean.setFirstName("s");
		// bean.setLastName("Verma");

		List list = model.search(bean);

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

}
