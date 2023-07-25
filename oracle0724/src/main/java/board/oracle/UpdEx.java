package board.oracle;

public class UpdEx {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto(12, "홍길철", "홍의 글제목", "홍의 글내용", "", 0);
		
		dao.updateOne(dto);
		

	}

}
