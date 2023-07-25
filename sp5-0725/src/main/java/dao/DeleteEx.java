package dao;

public class DeleteEx {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		dao.deleteOne(45L);

	}

}
