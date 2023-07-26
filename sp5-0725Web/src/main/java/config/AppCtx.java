package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
}
