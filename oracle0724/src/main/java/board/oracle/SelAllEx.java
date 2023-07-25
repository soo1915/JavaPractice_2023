package board.oracle;

import java.util.ArrayList;

public class SelAllEx {

	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.selectList();
		for(BoardDto dto : list) {
			System.out.println(dto);
		}
	}

}
