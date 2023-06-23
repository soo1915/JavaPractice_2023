package oracle0623;

import java.util.ArrayList;

public class ScoreServiceImp {
	ScoreDao dao = new ScoreDao();
	
	public ArrayList<ScoreDto> studentList() {
		return dao.selectList();
	}
	
	public int createScore(String name, int kor, int eng, int math) {
		int num = dao.maxNum();
		ScoreDto dto = new ScoreDto(num + 1, name, kor, eng, math);
		dao.insertOne(dto);
		return num;
	}
	
	public NumberDto selectMaxAnalyze() {
		return dao.selectMax();

	}
	
	public NumberDto selectAvgAnalyze() {
		return dao.selectAvg();
	}
	
	public double totalAvgAnalyze() {
		
		return dao.selectTotalAvg();
	}
}
