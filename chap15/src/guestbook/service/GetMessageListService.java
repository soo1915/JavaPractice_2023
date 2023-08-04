package guestbook.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class GetMessageListService {
	
	@Autowired
	private MessageDao messageDao;
	
	private static final int MESSAGE_COUNT_PER_PAGE = 3; // 한 페이지 당 보여주는 글 개수

	public MessageListView getMessageList(int pageNumber) {
		
		int currentPageNumber = pageNumber;
		int messageTotalCount = messageDao.selectCount();

		List<Message> messageList = null;
		int firstRow = 0;
		int endRow = 0;
		if (messageTotalCount > 0) {
			firstRow =
					(pageNumber - 1) * MESSAGE_COUNT_PER_PAGE + 1;
			endRow = firstRow + MESSAGE_COUNT_PER_PAGE - 1;
			messageList =
					messageDao.selectList(firstRow, endRow);
		} else {
			currentPageNumber = 0;
			messageList = Collections.emptyList();
		}
		return new MessageListView(messageList,
				messageTotalCount, currentPageNumber,
				MESSAGE_COUNT_PER_PAGE, firstRow, endRow);
		
	}
}