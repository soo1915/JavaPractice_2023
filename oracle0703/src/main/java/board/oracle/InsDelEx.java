package board.oracle;

public class InsDelEx {

	public static void main(String[] args) {

		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto(0, "홍길동", "홍길동전", "홍길동전 내용", "", 0);
		
		dao.insertOne(dto);
		dao.deleteOne(18);
	}

}
