package core;

import java.sql.SQLException;

import core.score.OracleScoreRepository;

public class OraTestEx1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		OracleScoreRepository osr = new OracleScoreRepository();
		if (osr.getConnection() != null) {
			System.out.println("오라클 테스트 ok");
		}
		
	}

}
