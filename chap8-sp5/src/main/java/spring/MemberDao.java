package spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberDao {

	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int count() {
		Integer count = jdbcTemplate.queryForObject("select count(*) from member", Integer.class);
		return count;
	}
	
	public List<Member> selectAll() {
		List<Member> results = jdbcTemplate.query("select * from member", new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(rs.getString("memberid"),
										   rs.getString("email"),
										   rs.getString("password"),
										   rs.getString("name"));
				return member;
			}
			
		});
		
		return results;
	}
	
	public void insert(Member member) {
		String sql = "insert into member(memberid, password, name, email) values (?, ?, ?, ?)";
		jdbcTemplate.update(sql, member.getMemberId(), member.getPassword(), member.getName(), member.getEmail());
	}
	
	public void update(Member member) {
		String sql = "update member set password = ?, name = ?, email = ? where memberid = ?";
		jdbcTemplate.update(sql, member.getPassword(), member.getName(), member.getEmail(), member.getMemberId());
	}
	
	public void delete(String id) {
		String sql = "delete from member where memberid = ?";
		jdbcTemplate.update(sql, id);
	}
}
