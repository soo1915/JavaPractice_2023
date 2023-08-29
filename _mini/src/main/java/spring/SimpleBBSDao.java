package spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class SimpleBBSDao {

	private JdbcTemplate jdbcTemplate;

	public SimpleBBSDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int selectCount() {
		String sql = "select count(*) from simple_bbs";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}	
	
	public List<SimpleBBS> selectList() {
		String sql = "select * from simple_bbs order by id desc";
		return jdbcTemplate.query(sql, (rs, s)->{
			SimpleBBS sbbs = SimpleBBS.builder().id(rs.getInt("id"))
												.writer(rs.getString("writer"))
												.title(rs.getString("title"))
												.content(rs.getString("content"))
												.user_id(rs.getInt("user_id"))
												.build();
			return sbbs;
		});
	}
	
	public SimpleBBS view(int id) {
		if (id <= 0) {
			throw new BBSNotFoundException("해당 id는 글이 없습니다.");
		}
		String sql = "select * from simple_bbs where id = ?";
		return this.jdbcTemplate.queryForObject(sql, (rs, n)->{
			SimpleBBS sbbs = SimpleBBS.builder().id(rs.getInt("id"))
					         .writer(rs.getString("writer"))
					         .title(rs.getString("title"))
					         .content(rs.getString("content"))
					         .user_id(rs.getInt("user_id")).build();
			return sbbs;
		}, id);
	}
	
	public int writer(SimpleBBS sbbs) {
		String sql = "insert into simple_bbs(writer, title, content, user_id) values (?, ?, ?, ?)";
		return this.jdbcTemplate.update(sql, sbbs.getTitle(), sbbs.getTitle(), sbbs.getContent(), sbbs.getUser_id());
		 
	}
	
	public int delete(int no) {
		String sql = "delete from simple_bbs where id = ?";
		return jdbcTemplate.update(sql, no);
	}
}
