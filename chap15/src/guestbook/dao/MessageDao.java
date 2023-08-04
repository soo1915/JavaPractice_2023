package guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import guestbook.model.Message;

public class MessageDao {
//	private static MessageDao messageDao = new MessageDao();
//	public static MessageDao getInstance() {
//		return messageDao;
//	}
//	
//	private MessageDao() {}
	
	private JdbcTemplate jdbcTemplate;
	public MessageDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int selectCount() {
		String sql = "select count(*) from guestbook_message";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
	
//	public int selectCount(Connection conn) throws SQLException {
//		Statement stmt = null;
//		ResultSet rs = null;
//		try {
//			stmt = conn.createStatement();
//			rs = stmt.executeQuery("select count(*) from guestbook_message");
//			rs.next();
//			return rs.getInt(1);
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(stmt);
//		}
//	}
	
	public int insert(Message message) {
		String sql = "insert into guestbook_message (guest_name, password, message) values (?, ?, ?)";
		return jdbcTemplate.update(sql, message.getGuestName(), message.getPassword(), message.getMessage());
	}
	
	public Message select(int id) {
		String sql = "select * from guestbook_message where message_id = ?"	;
		List<Message> results = jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message(rs.getString("guest_name"), rs.getString("password"), rs.getString("message"));
				message.setId(rs.getInt("message_id"));
				return message;
			}
			
		}, id);
		return results.isEmpty()?null:results.get(0);
	}
	
//	public Message select(Connection conn, int messageId) throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(
//					"select * from guestbook_message where message_id = ?");
//			pstmt.setInt(1, messageId);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				return makeMessageFromResultSet(rs);
//			} else {
//				return null;
//			}
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//	}

//	private Message makeMessageFromResultSet(ResultSet rs) throws SQLException {
//		Message message = new Message();
//		message.setId(rs.getInt("message_id"));
//		message.setGuestName(rs.getString("guest_name"));
//		message.setPassword(rs.getString("password"));
//		message.setMessage(rs.getString("message"));
//		return message;
//	}

	public List<Message> selectList(int firstRow, int endRow){
		String sql = "select * from guestbook_message order by message_id desc limit ?, ?";
		List<Message> results = jdbcTemplate.query(sql, new RowMapper<Message>() {

			@Override
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message(rs.getString("guest_name"), rs.getString("password"), rs.getString("message"));
				message.setId(rs.getInt("message_id"));
				return message;
			}
			
		}, firstRow - 1, endRow - firstRow + 1);
		return results;
	}

//	public List<Message> selectList(Connection conn, int firstRow, int endRow) 
//			throws SQLException {
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		try {
//			pstmt = conn.prepareStatement(
//					"select * from guestbook_message " + 
//					"order by message_id desc limit ?, ?");
//			pstmt.setInt(1, firstRow - 1);
//			pstmt.setInt(2, endRow - firstRow + 1);
//			rs = pstmt.executeQuery();
//			if (rs.next()) {
//				List<Message> messageList = new ArrayList<Message>();
//				do {
//					messageList.add(makeMessageFromResultSet(rs));
//				} while (rs.next());
//				return messageList;
//			} else {
//				return Collections.emptyList();
//			}
//		} finally {
//			JdbcUtil.close(rs);
//			JdbcUtil.close(pstmt);
//		}
//	}
	
	public int update(Message message, int i) {
		String sql = "update guestbook_message set guest_name = ?, password = ?, message = ? where message_id = ?";
		int results = jdbcTemplate.update(sql, message.getGuestName(), message.getPassword(), message.getMessage(), i);
		return results;
	}

	public int delete(int num) {
		String sql = "delete from guestbook_message where message_id = ?";
		return jdbcTemplate.update(sql, num);
	}
	
//	public int delete(Connection conn, int messageId) throws SQLException {
//		PreparedStatement pstmt = null;
//		try {
//			pstmt = conn.prepareStatement(
//					"delete from guestbook_message where message_id = ?");
//			pstmt.setInt(1, messageId);
//			return pstmt.executeUpdate();
//		} finally {
//			JdbcUtil.close(pstmt);
//		}
//	}

}
