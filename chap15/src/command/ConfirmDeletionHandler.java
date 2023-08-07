package command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmDeletionHandler implements CommandHandler {
	
	@Autowired
	private ConfirmDeletionHandler confirmDeletionHandler;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		String messageId = req.getParameter("messageId");
		req.setAttribute("messageId", messageId);
		return "/WEB-INF/view/confirmDeletion.jsp";
	}

}
