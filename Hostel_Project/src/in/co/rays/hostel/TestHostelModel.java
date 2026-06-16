package in.co.rays.hostel;

import java.util.Iterator;
import java.util.List;

public class TestHostelModel {
	public static void main(String[] args) throws Exception {
		// testNextPk();
		// testAdd();
		// testUpdate();
		// testDelete();
		testSearch();
	}

	private static void testSearch() throws Exception {
		HostelModel model = new HostelModel();
		HostelBean bean = new HostelBean();
		
		//bean.setRoomId(1);
		//bean.setRoomType("c");
		//bean.setStudentName("o");
		bean.setBlockName("3");
		
		List<HostelBean> list = model.search(bean);
		
		Iterator<HostelBean> it = list.iterator();
		while (it.hasNext()) {
			bean = it.next();
			System.out.println("Room ID : " + bean.getRoomId());
			System.out.println("Student Name : " + bean.getStudentName());
			System.out.println("Room Type : " + bean.getRoomType());
			System.out.println("FEE : " + bean.getFee());
			System.out.println("Block Type : " + bean.getBlockName());
			System.out.println("-----------------------------------------");
		}

	}

	private static void testDelete() throws Exception {
		HostelModel model = new HostelModel();
		HostelBean bean = new HostelBean();
		bean.setRoomId(5);
		model.delete(bean);

	}

	private static void testUpdate() throws Exception {
		HostelModel model = new HostelModel();
		HostelBean bean = new HostelBean();

		
		bean.setStudentName("Nunna");
		bean.setRoomType("Combined");
		bean.setFee(225000.00);
		bean.setBlockName("303 - D");
		bean.setRoomId(5);
		
		model.update(bean);

	}

	private static void testAdd() throws Exception {
		HostelModel model = new HostelModel();
		HostelBean bean = new HostelBean();

		bean.setRoomId(5);
		bean.setStudentName("Nunna");
		bean.setRoomType("Combined");
		bean.setFee(225000.0);
		bean.setBlockName("308 - E");

		model.add(bean);
	}

	private static void testNextPk() throws Exception {
		HostelModel model = new HostelModel();

		System.out.println("Next Pk : " + model.nextPk());
	}
}
