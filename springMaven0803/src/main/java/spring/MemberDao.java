package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

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
	
	public void update(Member member) {
		String sql = "update Member set name = ?, password = ?, regdate = ? where email = ?";
//		jdbcTemplate.update(sql, member.getName(), member.getPassword(), member.getEmail());
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, member.getName());
				pstmt.setString(2, member.getPassword());
				pstmt.setTimestamp(3, Timestamp.valueOf(member.getRegisterDateTime()));
				pstmt.setString(4, member.getEmail());
				
				return pstmt;
			}
		});
	}
	
	public Member insert(Member member) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		String sql = "insert into member (email, password, name, regdate) values (?, ?, ?, ?)";
		PreparedStatementCreator psc = (Connection con) -> {
			PreparedStatement pstmt = con.prepareStatement(sql, new String[] {"ID"});
			pstmt.setString(3, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
			pstmt.setString(1, member.getEmail());
			
			return pstmt;
		};

		jdbcTemplate.update(psc, keyHolder);
		Number keyValue = keyHolder.getKey();
		member.setId(keyValue.longValue());
		return member;
	}
}
