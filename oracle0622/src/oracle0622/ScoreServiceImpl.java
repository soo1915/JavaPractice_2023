package oracle0622;

import java.util.ArrayList;

public class ScoreServiceImpl {

	ScoreDao dao = new ScoreDao();
	
	int createScore(String name) throws ClassNotFoundException {
		int num = dao.selectMaxScore();
		ScoreDto dto = new ScoreDto(num + 1, name, 0, 0, 0);
		dao.insert(dto);
		return num + 1;
	}
	
	
	ScoreDto showOne(int num) throws ClassNotFoundException {
		ScoreDto dto = dao.selectOne(num);
		return dto;
	}
	
	String updateScore(int num, int kor, int math, int eng) throws ClassNotFoundException {
		if ((kor >= 0 && kor <= 100) && (math >= 0 && math <= 100) & (eng >= 0 && eng <= 100)){
			dao.update(num, kor, math, eng);
			return "입력이 완료되었습니다.";
		} else {
			return "점수값은 0 ~ 100 사이만 가능합니다.";
		}
		
	}
	
	ArrayList<ScoreDto> listScore() throws ClassNotFoundException {
		ArrayList<ScoreDto> list = dao.selectList();
		return list;
	}
	
	
}
