package oracle0703;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OraEx1 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			String sql = new StringBuffer().append("insert into board(num, writer, title, content, regtime, hits) values (SEQ_TEST.nextval,?,?,?,to_char(sysdate, 'YYYY-MM-DD HH:MI:SS'),0)").toString();
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, "홍길동");
			pstm.setString(2, "글제목입니다.");
			pstm.setString(3, "내용입니다.");
			int res = pstm.executeUpdate();
			System.out.println(res);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
