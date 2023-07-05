package board.oracle;

public class SelOneEx {

	public static void main(String[] args) {

		BoardDao dao = new BoardDao();
		BoardDto dto = dao.selectOne(14, false);
		System.out.println(dto);
	}

}
