package command;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import guestbook.service.DeleteMessageService;
import guestbook.service.InvalidPassowrdException;

public class DeleteMessageHandler implements CommandHandler {
	
	@Autowired
	private DeleteMessageService deleteMessageService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws UnsupportedEncodingException {
		int messageId = Integer.parseInt(req.getParameter("messageId"));
		String password = req.getParameter("password");
		boolean invalidPassowrd = false;
		try {
			deleteMessageService.deleteMessage(messageId, password);
		}catch(InvalidPassowrdException ex) {
			invalidPassowrd = true;
		}
		req.setAttribute("invalidPasswrd", invalidPassowrd);
		return "/WEB-INF/view/deleteMessage.jsp";
	}

}
