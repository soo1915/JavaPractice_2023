package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import guestbook.model.Message;
import guestbook.service.WriteMessageService;

public class WriteMessageHandler implements CommandHandler {
	
	@Autowired
	private WriteMessageService writeMessageService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		//jsp:useBean 과 동일한 역할을 함
		req.setCharacterEncoding("utf-8");
		String guestName = req.getParameter("guestName");
		String password = req.getParameter("password");
		String message = req.getParameter("message");
		Message msg = new Message(guestName, password, message);
		writeMessageService.write(msg);
		return "/WEB-INF/view/writeMessage.jsp";
	}

}
