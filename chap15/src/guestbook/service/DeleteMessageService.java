package guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;

import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class DeleteMessageService {

	@Autowired
	private MessageDao messageDao;
	
	public void deleteMessage(int messageId, String password) {
	
			Message message = messageDao.select(messageId);
			System.out.println(message);
			if (message == null) {
				throw new MessageNotFoundException("메시지 없음");
			}
			if (!message.matchPassword(password)) {
				throw new InvalidPassowrdException("bad password");
			}
			messageDao.delete(messageId);

			
	}
}