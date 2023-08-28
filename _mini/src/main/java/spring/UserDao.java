package spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public User selectId(Integer id) {
		String sql = "select * from myuser where id = ?";
		List<User> results = this.jdbcTemplate.query(sql, (rs, n) -> {
			return new User(rs.getInt("id"), rs.getString("name"), rs.getString("passwd"));
		},id);
		return results.isEmpty() ? null : results.get(0);
	}
	
	
}
