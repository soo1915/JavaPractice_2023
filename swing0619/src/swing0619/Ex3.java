package swing0619;

import java.sql.SQLException;
import java.util.ArrayList;

public class Ex3 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		BoardDao dao = new BoardDao();
		
		ArrayList<BoardDto> list = dao.selectList();
		
		for(BoardDto dto : list ) {
			System.out.println(dto);
		}

	}

}
