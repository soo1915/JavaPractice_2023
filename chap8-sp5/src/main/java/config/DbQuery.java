package config;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import spring.Member;

public class DbQuery {

	private DataSource dataSource;
	
	public DbQuery(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public int count() {
		Connection conn = null;
		try { 
			conn = dataSource.getConnection();
			// try-with-resources : try에 자원 객체를 전달하면 try 코드 블록이 끝나면 자동으로 자원을 종료해주는 기능
			try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("select count(*) from member")) {
					rs.next();
					return rs.getInt(1);
				}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch(SQLException e) {
				}
		}
	}
	
	public List selectAll() {
		Connection conn = null;
		ArrayList<Member> list = new ArrayList<Member>();
		try { 
			conn = dataSource.getConnection();
			Statement stmt = conn.createStatement();
			String sql = "select * from member";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				list.add(new Member(rs.getString("memberid"), rs.getString("password"), rs.getString("name"), rs.getString("email")));				
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
