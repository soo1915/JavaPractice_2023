package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.MemberDao;

@Configuration
public class DbQueryConfig {

	@Autowired
	private DataSource dataSource;
	
	@Bean
	public DbQuery dbQuery() {
		return new DbQuery(dataSource);
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource);
	}
}
