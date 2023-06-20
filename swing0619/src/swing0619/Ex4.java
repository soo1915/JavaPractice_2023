package swing0619;

import java.sql.SQLException;

public class Ex4 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{

		BoardDao dao = new BoardDao();
		BoardDto dto = new BoardDto();
		
		int res = dao.insertOne(dto);
		if(res == 1) {
			System.out.println("db 입력 성공");
		} else {
			System.out.println("db 입력 실패");
		}
	}

}
