package account0621;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDao {
	Connection getConnection() {
		Connection conn = null;

		try {
			Class.forName("org.mariadb.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3307/jspdb", "root", "maria");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	public ArrayList<AccountDto> selectList() {
		ArrayList<AccountDto> list = new ArrayList<>();
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select accnum, name, deposit from account");
			while (rs.next()) {
				int accnum = rs.getInt("accnum");
				String name = rs.getString("name");
				int deposit = rs.getInt("deposit");
				AccountDto dto = new AccountDto(accnum, name, deposit);
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	int selectMaxAccount() {
		int max = 0;
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = 
					stmt.executeQuery("SELECT MAX(accnum) FROM account");
			if (rs.next()) {
				max = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return max;
	}
	
	AccountDto selectOne(int num) {
		AccountDto dto = new AccountDto(0, "없음", 0);
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = 
					stmt.executeQuery("select accnum, name, deposit "
					+ "from account WHERE accnum = "+num);
			if (rs.next()) {
				int accnum = rs.getInt("accnum");
				String name = rs.getString("name");
				int deposit = rs.getInt("deposit");
				dto = new AccountDto(accnum, name, deposit);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	void insert(AccountDto dto) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql 
			= String.format("insert into account"
					+ " (accnum,name,deposit)"
					+ " values (%d, '%s', %d)"
			, dto.getAccnum(),dto.getName(),dto.getDeposit());
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void update(int deposit, int num) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql = String.format("UPDATE account SET deposit = %d "
					+ " WHERE accnum = %d", deposit, num);
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	void delete(int num) {
		try {
			Connection conn = this.getConnection();
			Statement stmt = conn.createStatement();
			String sql 
			= "delete from account where accnum = " + num;
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}