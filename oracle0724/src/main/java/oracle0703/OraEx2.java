package oracle0703;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class OraEx2 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn 
			= DriverManager.getConnection(url,user,password);
			String sql 
			= "select num,writer,title,content,regtime,hits "
					+ "from board where num = ?";
		
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, 8);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String writer = rs.getString("writer");
				String title = rs.getString("title");
				String content = rs.getString("content");
				String regtime = rs.getString("regtime");
				int hits = rs.getInt("hits");
				System.out.println(num+","+writer+","+title+","+content+
						","+regtime+","+hits);
			}
			rs.close();
			pstm.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
