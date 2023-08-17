package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import member.dao.MemberDao;



@Configuration
public class AppCtx {
	@Bean (destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/board?"
		         +"useSSL=true&useUnicode=true&characterEncoding=utf8");
		ds.setUsername("jspexam");
		ds.setPassword("jsppw");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		return ds;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

}







