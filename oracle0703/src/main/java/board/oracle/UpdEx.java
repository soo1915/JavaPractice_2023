package board.oracle;

public class UpdEx {

	public static void main(String[] args) {

		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto(14, "홍길동", "홍길동의 글제목", "홍길동의 글내용", null, 0);
		
		dao.updateOne(dto);
	}

}
