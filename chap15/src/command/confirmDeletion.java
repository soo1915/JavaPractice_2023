package command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class confirmDeletion implements CommandHandler {
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		
		return "/WEB-INF/view/confirmDeletion.jsp";
	}

}
