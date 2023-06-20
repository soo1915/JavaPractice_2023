package daodto0620;

import java.util.ArrayList;

public class Dao {
	
	ArrayList<Dto> dbtable = new ArrayList<>();
	
	Dao() {
		for(int i = 1; i <= 4; i++) {
			Dto dto = new Dto(i, "데이터" + i);
			dbtable.add(dto);
		}
	}
	
	void getConnection() {
		
	}
	
	ArrayList<Dto> selectList() {
		getConnection();
		ArrayList<Dto> lst = dbtable;
		return lst;
	}
	
	void insertOne(Dto dto) {
//		Dto dto = new Dto(num, str);
		dbtable.add(dto);
		
	}
}
