package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("out", "출력입니다.");
		return "/WEB-INF/view/out.jsp";
	}

}
