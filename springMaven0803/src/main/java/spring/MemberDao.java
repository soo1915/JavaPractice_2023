package spring;

import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class MemberDao {

	public JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Member selectByEmail(String email) {
		String sql = "select * from member where email = ?";
		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper(), email);
		return results.isEmpty() ? null : results.get(0);
	} 
	
	public List<Member> selectAll(){
		String sql = "select * from member";
//		List<Member> results = jdbcTemplate.query(sql, new MemberRowMapper());
		List<Member> results = jdbcTemplate.query(sql, (ResultSet rs, int rowNum)-> {
			Member member = new Member(
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("name"),
					rs.getTimestamp("regdate").toLocalDateTime());
			member.setId(rs.getLong("id"));
			return member;
		});
		return results;
	}
	
	public int count() {
		String sql = "select count(*) from member";
		List<Integer> results = jdbcTemplate.query(sql, (ResultSet rs, int rowNum)-> {
				return rs.getInt(1);
		});
		return results.get(0);
	}
}
