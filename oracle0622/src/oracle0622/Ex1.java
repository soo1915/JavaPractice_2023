package oracle0622;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
	
		String sql = "select * from emp";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int empno = rs.getInt("EMPNO");
			String ename = rs.getString("ENAME");
			String job = rs.getString("JOB");
			int mgr = rs.getInt("MGR");
			String hiredate = rs.getDate("HIREDATE") + "";
			int sal = rs.getInt("SAL");
			int comm = rs.getInt("COMM");
			int deptno = rs.getInt("DEPTNO");
			System.out.printf("%d, %s, %s, %d, %s, %d, %d, %d \n", empno, ename, job, mgr, hiredate, sal, comm, deptno);
		}
	
		
	
	}

}
