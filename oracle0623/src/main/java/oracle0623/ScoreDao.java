package oracle0623;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao {
	Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}

	public ArrayList<ScoreDto> selectList() {
		try {
			Connection conn = this.getConnection();
			ArrayList<ScoreDto> list = new ArrayList<>();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select num, name, kor, eng, math from score");
			while (rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				ScoreDto dto = new ScoreDto(num, name, kor, eng, math);
				list.add(dto);
			}
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public int maxNum() {
		int max = 0;
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(num) from score");
			if (rs.next()) {
				max = rs.getInt(1);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return max;
	}

	public int insertOne(ScoreDto dto) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql = String.format("insert into score (num,name,kor,eng,math) values (%d, '%s', %d, %d, %d)",
					dto.getNum(), dto.getName(), dto.getKor(), dto.getEng(), dto.getMath());
			return stmt.executeUpdate(sql);
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public NumberDto selectMax() {
		NumberDto dto = null;
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(kor), max(eng), max(math) from score");
			if (rs.next()) {
				int kor = rs.getInt(1);
				int eng = rs.getInt(2);
				int math = rs.getInt(3);
				dto = new NumberDto(kor, eng, math);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dto;
	}
	public NumberDto selectAvg() {
		NumberDto dto = null;
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select avg(kor), avg(eng), avg(math) from score");
			if (rs.next()) {
				int kor = rs.getInt(1);
				int eng = rs.getInt(2);
				int math = rs.getInt(3);
				dto = new NumberDto(kor, eng, math);
			}
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public double selectTotalAvg() {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select (sum(kor)+sum(eng)+sum(math))/(count(*)*3) from score");
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
