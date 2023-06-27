package core;

import java.util.List;

import core.score.Score;

public class ScoreApp {

	public static void main(String[] args) {

		AppConfig app = new AppConfig();
//		
//		Score score = new Score(1004L, 1, "국어", 76);
//		app.scoreRepository().save(score);
//		System.out.println("실행");
		
		List<Score> findSid = app.scoreRepository().findBySid(1003L);
		System.out.println(findSid);
		
		List<Score> findSub = app.scoreRepository().findBySubject("국어");
		System.out.println(findSub);
		
		int totalSum = app.scoreRepository().selectSumBySid(1003L);
		System.out.println(totalSum);
		
		double totalAvg = app.scoreRepository().selectAvgBySid(1003L);
		System.out.println(totalAvg);
	}

}
