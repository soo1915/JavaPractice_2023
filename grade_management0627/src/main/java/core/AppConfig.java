package core;

import core.score.OracleScoreRepository;

public class AppConfig {

	public OracleScoreRepository scoreRepository() {
		return new OracleScoreRepository();
	}
}

