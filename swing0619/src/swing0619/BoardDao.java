package swing0619;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class BoardDao {
	
	String getCurrentTime() {
		return LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);
	}

	Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		//System.out.println("드라이버 로딩!");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
		
		return conn;
	}
	
	ArrayList<BoardDto> selectList() throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection(); // this 생략 가능
		ArrayList<BoardDto> list = new ArrayList<>();
		Statement stmt = conn.createStatement(); 
		ResultSet rs = stmt.executeQuery("select num, writer, title, content from board");// select문일 때만 사용
		while (rs.next()) {
			int num = rs.getInt("num");
			String writer = rs.getString("writer");
			String title = rs.getString("title"); 
			String content = rs.getString("content");
			
			BoardDto dto = new BoardDto(num, writer, title, content);
			list.add(dto);
		}
		return list;
	}
	
	int insertOne(BoardDto dto) throws ClassNotFoundException, SQLException {
		Connection conn = this.getConnection();
		Statement stmt = conn.createStatement();
		String sql = String.format("insert into board(writer, title, content, regtime, hits) values ('%s', '%s','%s', '%s', 0)",
				dto.getWriter(), dto.getTitle(), dto.getTitle(), dto.getContent(), this.getCurrentTime());
		return stmt.executeUpdate(sql);
	}
}
