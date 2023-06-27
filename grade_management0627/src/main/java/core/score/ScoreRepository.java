package core.score;

import java.util.List;

public interface ScoreRepository {

	void save(Score score) ; // 한 과목 insert
	
	List<Score> findBySid(Long sid); // 학번으로 성적 검색
	List<Score> findBySubject(String subject); // 과목명으로 성적 검색
	int selectSumBySid(Long sid); // 학번으로 총점 리턴
	double selectAvgBySid(Long sid); // 학번으로 평균 리턴
}
