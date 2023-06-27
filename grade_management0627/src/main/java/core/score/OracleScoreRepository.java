package core.score;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class OracleScoreRepository implements ScoreRepository{
	
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	
	@Override
	public void save(Score score) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql = String.format("insert into score2(sid, seq, subject, score) values (%d, %d, '%s', %d)", score.getSid(), score.getSeq(), score.getSubject(), score.getScore());
			stmt.executeUpdate(sql);
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Score> findBySid(Long sid) {
		try {
			Connection conn = this.getConnection();
			ArrayList<Score> list = new ArrayList<>();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from score2 where sid = " + sid);
			while(rs.next()) {
				sid = rs.getLong("sid");
				int seq = rs.getInt("seq");
				String subject = rs.getString("subject");
				int score = rs.getInt("score");
				Score newScore = new Score(sid, seq, subject, score);
				list.add(newScore);
			}
			return list;
		
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Score> findBySubject(String subject) {
		try {
			Connection conn = this.getConnection();
			ArrayList<Score> list = new ArrayList<>();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from score2 where subject = '" + subject + "'");
			while(rs.next()) {
				Long sid = rs.getLong("sid");
				int seq = rs.getInt("seq");
				subject = rs.getString("subject");
				int score = rs.getInt("score");
				Score newScore = new Score(sid, seq, subject, score);
				list.add(newScore);
			}
			return list;
		
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectSumBySid(Long sid) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select sum(score) from score2 where sid = " + sid);
			if (rs.next()) {
				int totalSum = rs.getInt(1);
				return totalSum;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double selectAvgBySid(Long sid) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select avg(score) from score2 where sid = " + sid);
			if (rs.next()) {
				double totalAvg = rs.getDouble(1);
				return totalAvg;
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0.0;
	}

}
