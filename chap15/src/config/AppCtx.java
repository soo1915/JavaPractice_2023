package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import command.ConfirmDeletionHandler;
import command.DeleteMessageHandler;
import command.HelloHandler;
import command.ListHandler;
import command.WriteMessageHandler;
import guestbook.dao.MessageDao;
import guestbook.service.DeleteMessageService;
import guestbook.service.GetMessageListService;
import guestbook.service.WriteMessageService;

@Configuration
public class AppCtx {

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/guestbook?useSSL=true&useUnicode=true&characterEncoding=utf8");
		ds.setUsername("jspexam");
		ds.setPassword("jsppw");
		ds.setInitialSize(2); // 커넥션 풀을 초기화할 때 생성할 초기 커넥션 개수 (기본값은 10)
		ds.setMaxActive(10); // 커넥션 풀에서 가져올 수 있는 최대 커넥션 개수를 지정 (기본값은 100)
		return ds;
	}
	
	@Bean
	public MessageDao messageDao() {
		return new MessageDao(dataSource());
	}
	
	@Bean
	public DeleteMessageService deleteMessageService() {
		return new DeleteMessageService();
	}
	
	@Bean
	public GetMessageListService getMessageListService() {
		return new GetMessageListService();
	}
	
	@Bean
	public WriteMessageService writeMessageService() {
		return new WriteMessageService();
	}
	
	@Bean
	public HelloHandler helloHandler() {
		return new HelloHandler();
	}
	
	@Bean
	public ListHandler listHandler() {
		return new ListHandler();
	}
	
	@Bean
	public WriteMessageHandler writeMessageHandler() {
		return new WriteMessageHandler();
	}
	
	@Bean
	public DeleteMessageHandler deleteMessageHandler() {
		return new DeleteMessageHandler();
	}
	
	@Bean
	public ConfirmDeletionHandler confirmDeletionHandler() {
		return new ConfirmDeletionHandler();
	}
}
