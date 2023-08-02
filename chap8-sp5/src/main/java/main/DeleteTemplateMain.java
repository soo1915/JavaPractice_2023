package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQueryConfig;
import spring.MemberDao;

public class DeleteTemplateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class, DbQueryConfig.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		//Member member = new Member("test3", "2222", "강감찬", "aa@aa.com");
		memberDao.delete("test3");

	}

}
