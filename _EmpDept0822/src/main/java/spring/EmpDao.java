package spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class EmpDao {
	private JdbcTemplate jdbcTemplate;
	public EmpDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public int selectCount() {
		String sql = "select count(*) from emp";
		return this.jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	// emp 테이블 insert
	public void insert() {
		String sql = "insert into emp(ename, job, mgr, hiredate, sal, comm, deptno)"
				+ "values (?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				return null;
			}
		});
	}
	
	// dept 테이블 select
	public List<Dept> selectDept() {
		String sql = "select * from dept";
		return this.jdbcTemplate.query(sql, (rs, n)->{
			Dept dept = Dept.builder()
					.deptno(rs.getInt("deptno"))
					.dname(rs.getString("dname"))
					.loc(rs.getString("loc")).build();
			return dept;
		});
	}
	
}
