package article.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;

import article.model.ArticleContent;

public class ArticleContentDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ArticleContentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ArticleContent insert(ArticleContent content) {
		String sql = "insert into article_content article_no, content) values (?,?)";
		int insertedCount = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setLong(1, content.getNumber());
				pstmt.setString(2, content.getContent());
				return pstmt;
			}
		});
			
			if (insertedCount > 0) {
				return content;
			} else {
				return null;
			}

	}
	
	public ArticleContent selectById(int no) {
		String sql = "select * from article_content where article_no = ?";
		List<ArticleContent> list = jdbcTemplate.query(sql, new RowMapper<ArticleContent>() {

			@Override
			public ArticleContent mapRow(ResultSet rs, int rowNum) throws SQLException {
				ArticleContent content = new ArticleContent(
						rs.getInt("article_no"), rs.getString("content"));
				return content;
			}
		
		}, no);
		return list.isEmpty() ? null : list.get(0);
	}

	public int update(int no, String content) {
		String sql = "update article_content set content = ? where article_no = ?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, content);
				pstmt.setInt(2, no);
				return pstmt;
			}
		});
		return no;
	}
}

