package backend0706;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ResumeDao {

	Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	public void insertResume(ResumeDto dto) {
		try {
			Connection conn = this.getConnection();
			String sql = "insert into resume(num, name, phone, part, content, writedate) values "
					+ "(seq_test.nextval, ?, ?, ?, ?, to_char(sysdate, 'YYYY-MM-DD HH24:MI:SS'))";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, dto.getName());
			stmt.setString(2, dto.getPhone());
			stmt.setString(3, dto.getPart());
			stmt.setString(4, dto.getContent());
			stmt.executeUpdate();
			stmt.close();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<ResumeDto> selectList() {
		try {
			ArrayList<ResumeDto> list = new ArrayList<ResumeDto>();
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from resume order by num desc");
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String part = rs.getString("part");
				String content = rs.getString("content");
				String writedate = rs.getString("writedate");
				ResumeDto dto = new ResumeDto(num, name, phone, part, content, writedate);
				list.add(dto);
			} 
			
			rs.close();
			stmt.close();
			conn.close();
			return list;
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

}
