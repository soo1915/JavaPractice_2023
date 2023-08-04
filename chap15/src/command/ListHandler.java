package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import guestbook.service.GetMessageListService;
import guestbook.service.MessageListView;

public class ListHandler implements CommandHandler {
	
	@Autowired
	private GetMessageListService getMessageListService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) {
		String pageNumberStr = req.getParameter("page");
	 	int pageNumber = 1;
	 	if (pageNumberStr != null) {
	 		pageNumber = Integer.parseInt(pageNumberStr);
	 	}
	 	MessageListView viewData = 
	 			getMessageListService.getMessageList(pageNumber);
		req.setAttribute("viewData", viewData);
		return "/WEB-INF/view/list.jsp";
	}

}
