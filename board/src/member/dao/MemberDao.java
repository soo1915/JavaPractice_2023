package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import member.model.Member;

public class MemberDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public MemberDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int selectCount() {
		String sql = "select count(*) from member";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	public Member selectById(String id) throws SQLException {
		
		String sql = "select * from member where memberid = ?";
		
		List<Member> results = jdbcTemplate.query(sql, new RowMapper<Member>() {

			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				Member member = new Member(
						rs.getString("memberid"), 
						rs.getString("name"), 
						rs.getString("password"),
						toDate(rs.getTimestamp("regdate")));
				return member;
			}
			
	}, id);
		
		return results.isEmpty() ? null : results.get(0);
	}

	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}

	public void insert(Member mem) throws SQLException {
		
		String sql = "insert into member values(?,?,?,?)";
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = 
				con.prepareStatement(sql); 
				pstmt.setString(1, mem.getId());
				pstmt.setString(2, mem.getName());
				pstmt.setString(3, mem.getPassword());
				pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime()));
				return pstmt;
			
				}
			});
		}	



	public void update(Member member) throws SQLException {
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(
						"update member set name = ?, password = ? where memberid = ?");
					pstmt.setString(1, member.getName());
					pstmt.setString(2, member.getPassword());
					pstmt.setString(3, member.getId());
				return pstmt;
			}
		});
		
	}	
}
