package guestbook.service;

import org.springframework.beans.factory.annotation.Autowired;

import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class WriteMessageService {

	@Autowired
	private MessageDao messageDao;
	
	public void write(Message message) {

		messageDao.insert(message);
	} 


}