package board.oracle;

public class InsDelEx {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		BoardDto dto 
			= new BoardDto(0, "강하나", "글제목", "글내용", "", 0);
		dao.insertOne(dto);

	}

}
