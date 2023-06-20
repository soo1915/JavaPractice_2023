package daodto0620.fin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Dao {

	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
		
		return conn;
	}
	
	ArrayList<Dto> selectList() throws ClassNotFoundException, SQLException {
		ArrayList<Dto> list = new ArrayList<>();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "Select id, name, addr, phone from person";
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String name = rs.getString("name");
			String addr = rs.getString("addr");
			String phone = rs.getString("phone");
			
			Dto dto = new Dto(id, name, addr, phone);
			list.add(dto);
		}
		return list;
	}
	
	ArrayList<Dto> selectOne(String name, String addr, String phone) throws ClassNotFoundException, SQLException {
		ArrayList<Dto> list = new ArrayList<>();
		
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = String.format("Select id, name, addr, phone from person where name like '%%%s%%' "
								+ "and addr like '%%%s%%' and phone like '%%%s%%'", name, addr, phone );
		System.out.println(sql);
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()) {
			int id = rs.getInt("id");
			name = rs.getString("name");
			addr = rs.getString("addr");
			phone = rs.getString("phone");
			
			Dto dto = new Dto(id, name, addr, phone);
			list.add(dto);
		}
		return list;
	}
	
	void insert(Dto dto) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = String.format("insert into person (name, addr, phone) values ('%s', '%s', '%s')",dto.getName(), dto.getAddr(), dto.getPhone());
		stmt.executeUpdate(sql);
		
	}
	
	void update(Dto dto) throws SQLException, ClassNotFoundException {
		Connection conn = getConnection();
		Statement stmt= conn.createStatement();
		String sql = String.format("update person set name = '%s', addr = '%s', phone = '%s' where id = '%d'", dto.getName(), dto.getAddr(), dto.getPhone(), dto.getId());
		stmt.executeUpdate(sql);
	}
	
	void delete(int id) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = String.format("delete from person where id = '%s'", id);
		stmt.executeUpdate(sql);
	}
	
	
}
