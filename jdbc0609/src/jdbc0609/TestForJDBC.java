package jdbc0609;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class TestForJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		String url = "jdbc:mariadb://localhost:3307/jspdb";
		String user = "root";
		String pass = "maria";
		Class.forName("org.mariadb.jdbc.Driver");
		System.out.println("드라이버 로딩!");
		conn = DriverManager.getConnection(url, user, pass);
		System.out.println("접속 성공!");

		
		Scanner scan = new Scanner(System.in);
		System.out.print("empno 입력 >");
		int empno = Integer.parseInt(scan.nextLine());
		System.out.print("ename 입력 >");
		String ename = scan.nextLine();
		System.out.print("sal 입력 >");
		int sal = Integer.parseInt(scan.nextLine());
		System.out.print("phone 입력 >");
		String phone = scan.nextLine();		
		
		
		String sql = "INSERT INTO emp VALUES (" + empno + ", \"" + ename +"\"," + sal + ",\"" + phone + "\")";
		System.out.println(sql);
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(sql);
		System.out.println("query 성공");
		
	}

}
