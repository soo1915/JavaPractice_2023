package oracle0703;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OraExSelectOne0704 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Scanner scan = new Scanner(System.in);
			System.out.print("num값 입력 : ");
			int num = Integer.parseInt(scan.nextLine());
			String sql = "select num, title, writer, content, regtime, hits from board where num = " + num;
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			Board board = new Board();
			
			if(rs.next()) {
				board.setNum(rs.getInt("num"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setRegtime(rs.getString("regtime"));
				board.setHits(rs.getInt("hits"));
				System.out.println(board.toString());
			}
			rs.close();
			pstm.close();
			conn.close();
			scan.close();

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
