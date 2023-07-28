package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import service.BoardService;

public class ListHandler implements CommandHandler {

	@Autowired
	BoardService boardService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		
		
//		BoardService boardService = ControllerUsingURI.ctx.getBean("boardService", BoardService.class);
		
		req.setAttribute("list", boardService.findAll());
		return "/WEB-INF/view/list.jsp";
	}

}