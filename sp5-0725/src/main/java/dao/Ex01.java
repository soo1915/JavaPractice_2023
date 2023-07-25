package dao;

import java.util.ArrayList;

public class Ex01 {

	public static void main(String[] args) {

		BoardDao dao = new BoardDao();
		ArrayList<BoardDto> list = dao.selectList();
		for(BoardDto dto : list) {
			System.out.println(dto);
		}
	}

}
