package article.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import article.model.Article;
import article.model.Writer;

public class ArticleDao {
	
	private JdbcTemplate jdbcTemplate;
	
	public ArticleDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Article insert(Article article) {
		String sql = "insert into article "
				+ "(writer_id, writer_name, title, regdate, moddate, read_cnt) "
				+ "values (?,?,?,now(),now(),0)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update((con) -> {
			PreparedStatement pstm 
			  = con.prepareStatement(sql, new String[] {"article_no"});
			pstm.setString(1, article.getWriter().getId());
			pstm.setString(2, article.getWriter().getName());
			pstm.setString(3, article.getTitle());
			return pstm;
		}, keyHolder);
		Number keyValue = keyHolder.getKey();
		article.setNumber(keyValue.intValue());
		return article;
		
//		int insertedCount = jdbcTemplate.update(sql,
//				                    article.getWriter().getId(),
//				                    article.getWriter().getName(),
//				                    article.getTitle());
//		if (insertedCount > 0) {
//			int num = jdbcTemplate.queryForObject("select last_insert_id()",
//													    	Integer.class);
//			article.setNumber(num);
//			return article;
//		}
//		return null;
				
	}

	private Timestamp toTimestamp(Date date) {
		return new Timestamp(date.getTime());
	}

	public int selectCount() {
		String sql = "select count(*) from article";
		
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}

	public List<Article> select(int startRow, int size) {
		String sql = "select * from article " +
				"order by article_no desc limit ?, ?";
		
		return jdbcTemplate.query(sql, 
				(rs, n) -> convertArticle(rs), startRow, size);

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
		List<Article> list = jdbcTemplate.query(sql,
				               (rs, n) -> convertArticle(rs), no);
		return list.isEmpty() ? null : list.get(0);
	}
	
	public void increaseReadCount(int no) {
		String sql = "update article set read_cnt = read_cnt + 1 "+
				"where article_no = ?";
		jdbcTemplate.update(sql, no);
	}
	
	public int update(int no, String title) {
		String sql = "update article set title = ?, moddate = now() "+
				"where article_no = ?";
		return jdbcTemplate.update(sql, title, no);
	}
	
	public int delete(int no) {
		String sql = "delete from article where article_no = ?";
		return jdbcTemplate.update(sql, no);
	}
}
