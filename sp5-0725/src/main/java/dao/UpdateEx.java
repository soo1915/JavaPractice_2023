package dao;

public class UpdateEx {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto(45L, "글이오", "제목이오", "내용이오", null, 0);
		dao.updateOne(dto);
	}

}
