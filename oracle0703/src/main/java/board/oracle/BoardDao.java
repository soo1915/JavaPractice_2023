package board.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BoardDao implements Board{

	@Override
	public Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	@Override
	public ArrayList<BoardDto> selectList() {
		ArrayList<BoardDto> list = new ArrayList<BoardDto>(); 
		Connection conn = this.getConnection();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from board order by num desc");
			while (rs.next()) {
				
				int num = rs.getInt("num");
				String title = rs.getString("title");
				String writer = rs.getString("writer" );
	            String regtime = rs.getString("regtime");
	            String content = rs.getString("content");
	            int hits = rs.getInt   ("hits"   );
	            BoardDto dto = new BoardDto(num, writer, title, content, regtime, hits);
				list.add(dto);
			}
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardDto selectOne(int num, boolean incHits) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertOne(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOne(BoardDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOne(int num) {
		// TODO Auto-generated method stub
		
	}

}
