package article.dao;

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

import article.model.Article;
import article.model.Writer;

public class ArticleDao {

	private JdbcTemplate jdbcTemplate;
	
	public ArticleDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public Article insert(Article article) {
		String insSql = "insert into article "
					+ "(writer_id, writer_name, title, regdate, moddate, read_cnt) "
					+ "values (?,?,?,?,?,0)";
		int insertedCount = jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(insSql);
				pstmt.setString(1, article.getWriter().getId());
				pstmt.setString(2, article.getWriter().getName());
				pstmt.setString(3, article.getTitle());
				pstmt.setTimestamp(4, toTimestamp(article.getRegDate()));
				pstmt.setTimestamp(5, toTimestamp(article.getModifiedDate()));
				return pstmt;
			}
		});
		
		if (insertedCount > 0) {
			String selSql = "select last_insert_id() from article";
			List<Article> list = jdbcTemplate.query(selSql, new RowMapper<Article>() {

				@Override
				public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

					Integer newNo = rs.getInt(1);
					return new Article(newNo,
							article.getWriter(),
							article.getTitle(),
							article.getRegDate(),
							article.getModifiedDate(),
							0);
				}
				
			});
			return list.isEmpty() ? null : list.get(0);
		}
		return null;
	} 
		

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount() {
		String sql = "select count(*) from article";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}

	public List<Article> select(int startRow, int size) {
		String sql = "select * from article order by article_no desc limit ?, ?";
		List<Article> result = jdbcTemplate.query(sql, new RowMapper<Article>() {

			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Writer writer = new Writer(rs.getString("writer_id"), rs.getString("writer_name"));
				Article article = new Article(rs.getInt("article_no"), writer, 
						rs.getString("writer_name"), rs.getDate("regdate"), rs.getDate("moddate"), rs.getInt("read_cnt"));
				return article;
			}
		}, startRow - 1, size - startRow + 1);
			
			return result;
		} 
	

	private Article convertArticle(ResultSet rs) throws SQLException {
		return new Article(rs.getInt("article_no"),
				new Writer(
						rs.getString("writer_id"),
						rs.getString("writer_name")),
				rs.getString("title"),
				toDate(rs.getTimestamp("regdate")),
				toDate(rs.getTimestamp("moddate")),
				rs.getInt("read_cnt"));
	}

	private Date toDate(Timestamp timestamp) {
		return new Date(timestamp.getTime());
	}
	
	public Article selectById(int no) {
		String sql = "select * from article where article_no = ?";
		List<Article> list = this.jdbcTemplate.query(sql, (rs, r) -> {
			Article article = convertArticle(rs);
			return article;
		}, no);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void increaseReadCount(int no) {
		String sql = "update article set read_cnt = read_cnt + 1 where article_no = ?"; 
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, no);
				return pstmt;
			}
		});
		
	}
	
	public int update(int no, String title) {
		String sql = "update article set title = ?, moddate = now() where article_no = ?";
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, title);
				pstmt.setInt(2, no);
				return pstmt;
			}
		});
		return no;
	}
}

