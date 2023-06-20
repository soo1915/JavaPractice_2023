package daodto0620.fin;

import java.sql.SQLException;
import java.util.ArrayList;

public class Ex1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Dao dao = new Dao();
		
		// insert query
//		Dto person = new Dto(12, "hong", "Busan", "010-1234-1234");

		// update query
//		dao.update(person);
//		
		// delete query
		//dao.delete(12);

		//select like query
		ArrayList<Dto> list = dao.selectOne("홍", "", "");
		for(Dto dto : list) {
			System.out.println(dto);
		} 
		
		//select ArrayList
//		ArrayList<Dto> lst = dao.selectList();
//		for(Dto dto : lst) {
//			System.out.println(dto);
//		}
		
		
	}

}
