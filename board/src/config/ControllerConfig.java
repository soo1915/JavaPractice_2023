package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.service.ListArticleService;
import article.service.ModifyArticleService;
import article.service.ReadArticleService;
import article.service.WriteArticleService;
import auth.service.LoginService;
import controller.ArticleController;
import controller.LogController;
import controller.MyController;
import member.dao.MemberDao;
import member.service.ChangePasswordService;
import member.service.JoinService;

@Configuration
@EnableTransactionManagement
//@MapperScan(basePackages = "mybatis.dao")
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
	public ArticleDao articleDao() { 
		return new ArticleDao(dataSource());
	}
	
	@Bean
	public ArticleContentDao articleContentDao() {
		return new ArticleContentDao(dataSource());
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
	
	@Bean
	public ListArticleService listArticleService() {
		return new ListArticleService();
	}
	
	@Bean
	public ModifyArticleService modifyArticleService() {
		return new ModifyArticleService();
	}
	
	@Bean
	public ReadArticleService readArticleService() {
		return new ReadArticleService();
	}
	
	@Bean
	public WriteArticleService writeArticleService() {
		return new WriteArticleService();
	}

	@Bean // 스프링 책 213 페이지에 있음
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		return (SqlSessionFactory) sqlSessionFactory.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory());
	}

	@Bean
	public MyController myController() {
		return new MyController();
	}

	@Bean
	public LogController logController() {
		return new LogController();
	}
	
	@Bean
	public ArticleController articleController() {
		return new ArticleController();
	}

}
