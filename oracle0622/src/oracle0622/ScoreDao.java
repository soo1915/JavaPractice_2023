package oracle0622;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ScoreDao {

	Connection getConnection() throws ClassNotFoundException, SQLException{
		
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return conn;
	}
	
	public ArrayList<ScoreDto> selectList() throws ClassNotFoundException{
		ArrayList<ScoreDto> list = new ArrayList<>();
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from score");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int eng = rs.getInt("eng");
				int math = rs.getInt("math");
				ScoreDto dto = new ScoreDto(num, name, kor, eng, math);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	int selectMaxScore() throws ClassNotFoundException {
		int max = 0;
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select max(num) from score");
			if (rs.next()) {
				max = rs.getInt(1);
			}
		} catch (SQLException e){ 
			e.printStackTrace();
		}
		return max;
	}
	
	ScoreDto selectOne(int num) throws ClassNotFoundException {
		ScoreDto dto = new ScoreDto(0, "", 0, 0, 0);
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from score where num = " + num);
			if (rs.next()) {
				num = rs.getInt("num");
				String name = rs.getString("name");
				int kor = rs.getInt("kor");
				int math = rs.getInt("math");
				int eng = rs.getInt("eng");
				dto = new ScoreDto(num, name, kor, math, eng);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	void insert(ScoreDto dto)  {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql = String.format("insert into score (num, name, kor, math, eng) values (%d, '%s', %d, %d, %d)" ,
					dto.num, dto.name, dto.kor, dto.math, dto.eng);
			stmt.executeUpdate(sql);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	} 
	
	
	// update query 작성 아직 안 함
	void update(int num, int kor, int math, int eng) throws ClassNotFoundException {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql = String.format("update score set kor = %d , math = %d, eng = %d where num = %d", kor, math, eng, num);
			stmt.executeUpdate(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	void delete(int num) throws ClassNotFoundException {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "delete from score where num = " + num;
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
