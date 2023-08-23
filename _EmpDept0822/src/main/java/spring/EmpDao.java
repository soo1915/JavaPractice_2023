package spring;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

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
	public int insert(Emp emp) {
		String sql = "insert into emp(ename, job, mgr, hiredate, sal, comm, deptno)"
				+ "values (?, ?, ?, now(), ?, ?, ?)";
		return this.jdbcTemplate.update(sql, emp.getEname(), emp.getJob(), emp.getMgr(), emp.getSal(), emp.getComm(), emp.getDeptno());
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
	
	public List<Emp> selectEmp(){
		String sql = "select empno, ename, deptno from emp";
		return this.jdbcTemplate.query(sql, (rs, n)->{
			Emp emp = Emp.builder().empno(rs.getInt("empno")).ename(rs.getString("ename")).deptno(rs.getInt("deptno")).build();
			return emp;
		});
	}
	
}
