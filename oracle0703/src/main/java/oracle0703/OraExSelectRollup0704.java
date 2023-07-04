package oracle0703;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class OraExSelectRollup0704 {

	public static void main(String[] args) {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "scott";
		String password = "tiger";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn = DriverManager.getConnection(url, user, password);
			
			String sql = "select deptno, nvl(to_char(hiredate, 'YYYY'), '합계'), count(*), max(sal), sum(sal), round(avg(sal), 2) from emp"
					+ " group by rollup(deptno, to_char(hiredate, 'YYYY'))";
			PreparedStatement pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String hiredate = rs.getString(2);
				int count = rs.getInt(3);
				int maxSal = rs.getInt(4);
				int sumSal = rs.getInt(5);
				double avgSal = rs.getDouble(6);
				System.out.println(deptno + "\t" + hiredate + "\t" + count + "\t" + maxSal + "\t" + sumSal + "\t" + avgSal);
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
