package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import auth.service.LoginService;
import controller.LogController;
import controller.MyController;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.JoinService;

@Configuration
@EnableTransactionManagement
public class ControllerConfig {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/board?useSSL=true&useUnicode=true&characterEncoding=utf8");
		ds.setUsername("jspexam");
		ds.setPassword("jsppw");
		ds.setInitialSize(2); // 커넥션 풀을 초기화할 때 생성할 초기 커넥션 개수 (기본값은 10)
		ds.setMaxActive(10); // 커넥션 풀에서 가져올 수 있는 최대 커넥션 개수를 지정 (기본값은 100)
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}
	
	@Bean
	public LoginService loginService() {
		return new LoginService();
	}
	
	@Bean
	public ChangePasswordService changePasswordService() {
		return new ChangePasswordService();
	}
	
	@Bean
	public JoinService joinService() {
		return new JoinService();
	}
	
	@Bean // 스프링 책 213 페이지에 있음
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}
	
	@Bean
	public MyController myController() {
		return new MyController();
	}
	
	@Bean
	public LogController logController() {
		return new LogController();
	}
	
	
	
}
