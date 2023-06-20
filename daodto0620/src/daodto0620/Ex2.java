package daodto0620;

import java.util.ArrayList;

public class Ex2 {

	public static void main(String[] args) {
		
		Dao dao = new Dao();
		Dto d = new Dto(5, "데이터5");
		dao.insertOne(d);
		
		ArrayList<Dto> list = dao.selectList();
		for(Dto dto : list) {
			System.out.println(dto);
		}
	}

}
