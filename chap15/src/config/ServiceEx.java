package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import guestbook.model.Message;
import guestbook.service.DeleteMessageService;
import guestbook.service.GetMessageListService;
import guestbook.service.WriteMessageService;

public class ServiceEx {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		DeleteMessageService ds = ctx.getBean("deleteMessageService", DeleteMessageService.class);
		GetMessageListService gs = ctx.getBean("getMessageListService", GetMessageListService.class);
		WriteMessageService ws = ctx.getBean("writeMessageService", WriteMessageService.class);
		// 삭제하기
		//ds.deleteMessage(4, "1234"); // jspexam 사용자 guestbook
		
//		// 페이지에 맞게 출력
//		MessageListView mlv = gs.getMessageList(1);
//		List<Message> list = mlv.getMessageList();
//		for (Message m : list) {
//			System.out.println(m);
//		}
		
		// 작성
		Message message = new Message("이순신", "1111", "하이..."); 
		ws.write(message);
	}

}
