package dao;

public class SelectOneEx {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		System.out.println(dao.selectOne(2L, true));
	}

}
