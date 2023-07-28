package command;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutHandler implements CommandHandler{

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		req.setAttribute("out", new Date());
		return "/WEB-INF/view/out.jsp";
	}

}
