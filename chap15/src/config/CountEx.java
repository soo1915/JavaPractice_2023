package config;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import guestbook.dao.MessageDao;
import guestbook.model.Message;

public class CountEx {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MessageDao messageDao = ctx.getBean("messageDao", MessageDao.class);
		// count
		System.out.println(messageDao.count());
		// insert
		Message msg = new Message("강감찬", "1234", "hello");
		messageDao.insert(msg);
		// selectone
		System.out.println(messageDao.select(1));
		// selectall
		List<Message> list = messageDao.selectList(1,3);
		for (Message m : list) {
			System.out.println(m);
		}
		//delete
		System.out.println(messageDao.delete(5));
		//update
		msg = new Message("강감찬", "1234", "hello");
		System.out.println(messageDao.update(msg, 4));
	}

}
