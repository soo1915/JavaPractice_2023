package dao;

public class InsertEx {

	public static void main(String[] args) {
		
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto(9L, "글쓴이", "글제목", "글내용", null, 0);
		dao.insertOne(dto);
	}

}
