package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import command.HelloHandler;
import command.ListHandler;
import command.OutHandler;
import command.ViewHandler;
import dao.BoardDao;
import service.BoardServiceImpl;

@Configuration
public class AppCtx {
	
	@Bean
	public BoardDao boardDao() {
		return new BoardDao();
	}
	
	@Bean
	public BoardServiceImpl boardService() {
		BoardServiceImpl boardService = new BoardServiceImpl(boardDao()); // 생성자 방식
		//boardService.setDao(boardDao()); // 세터 방식
		return boardService;
	}
	
	@Bean
	public HelloHandler helloHandler() {
		return new HelloHandler();
	}
	
	@Bean
	public OutHandler outHandler() {
		return new OutHandler();
	}
	
	@Bean
	public ListHandler listHandler() {
		return new ListHandler();
	}
	
	@Bean
	public ViewHandler viewHandler() {
		return new ViewHandler();
	}
}
