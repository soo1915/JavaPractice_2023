package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import service.BoardService;

public class ViewHandler implements CommandHandler{

	@Autowired
	BoardService boardService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		Long num = Long.parseLong(req.getParameter("num"));
		//BoardDto dto = boardService.findOne(num, true);
		req.setAttribute("num", num);
		req.setAttribute("dto", boardService.findOne(num, true));
		
		return "/WEB-INF/view/view.jsp";
	}

}
