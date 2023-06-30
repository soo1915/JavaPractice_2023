package maria0630;

import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BoardDao {

	Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
		return conn;
	}
	
	public ArrayList<BoardDto> selectList()	{
		try {
			Connection conn = this.getConnection();
			ArrayList<BoardDto> list = new ArrayList<>();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from board order by num desc");
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regtime = rs.getString("regtime");
				int hits = rs.getInt("hits");
				BoardDto dto = new BoardDto(num, writer, title, content, regtime, hits);
				list.add(dto);
			}
			
			return list;
		} catch (SQLException | ClassNotFoundException e){
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int createBoard(int num, String writer, String title, String content, String regtime, int hits) {
		int max = selectMaxNum();
		BoardDto dto = new BoardDto(max+1, writer, title, content, regtime, 0);
		insertBoard(dto);
		return num;
	}
	
	 public int insertBoard(BoardDto dto) {
		 try {
				Connection conn = this.getConnection();
				Statement stmt = conn.createStatement();
				int max = selectMaxNum();
				String curTime = LocalDate.now() + " " + LocalTime.now().toString().substring(0, 8);
				String sql = String.format("insert into board(num, writer, title, content, regtime, hits) values ('%s', '%s', '%s', '%s', '%s', 0)",
											max+1, dto.getWriter(), dto.getTitle(), dto.getContent(), curTime, 0);
				return stmt.executeUpdate(sql);
	
				
			} catch (SQLException | ClassNotFoundException e){
				e.printStackTrace();
			}
		 return 0;
	 }
	 
	 public int selectMaxNum() {
		 int max = 0;
		 try {
			 Connection conn = this.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = 
						stmt.executeQuery("SELECT MAX(num) FROM board");
			 if (rs.next()) {
				 max = rs.getInt(1);
			 }
		 } catch (SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 return max;
	 }
	 
	 public ArrayList<BoardDto> selectOne(int num) {
		 ArrayList<BoardDto> list = new ArrayList<>();
		 try {
			 Connection conn = this.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("select title, writer, regtime, hits, content from board where num = " + num );
			 if(rs.next()) {
				 String title = rs.getString("writer");
				 String writer = rs.getString("writer");
				 String regtime = rs.getString("regtime");
				 int hits = rs.getInt("hits");
				 String content = rs.getString("content");
				 
				 title   = title.replace  (" ", "&nbsp;");
		         content = content.replace(" ", "&nbsp;").replace("\n", "<br>");
				 BoardDto dto = new BoardDto(num, writer, title, content, regtime, hits);
				 list.add(dto);
			 }
			 return list;
		 } catch (SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		return null;
	 }
	 
	 public String selectForUpdate(int num, String writer, String content, String title) {
		 String action = null;
		 try {
			 Connection conn = this.getConnection();
			 Statement stmt = conn.createStatement();
			 ResultSet rs = stmt.executeQuery("select title, writer, regtime, hits, content from board where num = " + num );
			 if(rs.next()) {
				 writer  = rs.getString("writer" );
	             title   = rs.getString("title"  );
	             content = rs.getString("content");
				
	             action  = "update.jsp?num=" + num;
			 }
			 return action;
		 } catch (SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		return action;
	 }
	 
	 public int updateHits(int num) {
		 try {
			 Connection conn = this.getConnection();
			 Statement stmt = conn.createStatement();
			 stmt.executeUpdate("update board set hits=hits+1 where num=" + num);
		 } catch (SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
		 return num;
	 }
	 
	 public void updateBoard(int num, String writer, String title, String content) {
		 try {
			 Connection conn = this.getConnection();
			 Statement stmt = conn.createStatement();
			 String curTime = LocalDate.now() + " " + 
                     LocalTime.now().toString().substring(0, 8);
			 stmt.executeUpdate(String.format(
	                 "update board set writer='%s', title='%s', " +
	                 "content='%s', regtime='%s' where num=%d",
	                 writer, title, content, curTime, num));
		 } catch(SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		 }
	 }
	 
	 public void deleteBoard(int num) {
		 try {
			 Connection conn = this.getConnection();
			 Statement stmt = conn.createStatement();
			 String sql = "delete from board where num=" + num;
			 stmt.executeUpdate(sql);
		 } catch(SQLException | ClassNotFoundException e	) {
			 e.printStackTrace();
		 }
	 }
	
}
