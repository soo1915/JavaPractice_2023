package daodto0620;

import java.util.ArrayList;


public class Ex1 {

	public static void main(String[] args) {
		
		ArrayList<Dto> list = new ArrayList<>();
		
		//list에 객체를 생성해서 넣기
		
		
		for(int i = 1; i <= 4; i++) {
			Dto dto = new Dto(i, "데이터" + i);
			list.add(dto);
		}
		
		for (Dto dto : list) {
			System.out.println(dto.toString());
		}
	}

}
