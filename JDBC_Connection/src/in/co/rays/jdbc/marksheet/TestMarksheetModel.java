package in.co.rays.jdbc.marksheet;

import java.util.Iterator;
import java.util.List;

public class TestMarksheetModel {
	public static void main(String[] args) throws Exception {
		// testnextPk();
		// testAdd();
		// testUpdate();
		// testDelete();
		// testFindByRollno();
		// testFindByPk();
		testSearch();

	}

	private static void testSearch() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setName("k");
		List<MarksheetBean> list = model.search(bean);

		Iterator<MarksheetBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println("Id : " + bean.getId());
			System.out.println("Roll no : " + bean.getRollno());
			System.out.println("Name : " + bean.getName());
			System.out.println("Physics : " + bean.getPhy());
			System.out.println("Chemistry : " + bean.getChm());
			System.out.println("Maths : " + bean.getMaths());
			System.out.println("------------------------------");
		}

	}

	private static void testFindByPk() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByPk(1);
		if (bean == null) {
			System.out.println("Student not found");
		} else {
			System.out.println("Id : " + bean.getId());
			System.out.println("Roll no : " + bean.getRollno());
			System.out.println("Name : " + bean.getName());
			System.out.println("Physics : " + bean.getPhy());
			System.out.println("Chemistry : " + bean.getChm());
			System.out.println("Maths : " + bean.getMaths());
			System.out.println("--------------------------------");
		}

	}

	private static void testFindByRollno() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean = model.findByRollno(2);
		if (bean == null) {
			System.out.println("Student not found");
		} else {
			System.out.println("Id : " + bean.getId());
			System.out.println("Roll no : " + bean.getRollno());
			System.out.println("Name : " + bean.getName());
			System.out.println("Physics : " + bean.getPhy());
			System.out.println("Chemistry : " + bean.getChm());
			System.out.println("Maths : " + bean.getMaths());
			System.out.println("----------------------------");
		}

	}

	private static void testDelete() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		bean.setId(3);
		model.delete(bean);

	}

	private static void testUpdate() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		bean.setRollno(3);
		bean.setName("Raghav");
		bean.setPhy(89);
		bean.setChm(99);
		bean.setMaths(99);
		bean.setId(3);

		model.update(bean);

	}

	private static void testAdd() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();
		bean.setRollno(3);
		bean.setName("Raghav");
		bean.setPhy(99);
		bean.setChm(99);
		bean.setMaths(99);

		model.add(bean);
	}

	private static void testnextPk() throws Exception {
		MarksheetBean bean = new MarksheetBean();
		MarksheetModel model = new MarksheetModel();

		System.out.println("Next primary key : " + model.nextPk());
	}

}
