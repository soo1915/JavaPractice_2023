package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQueryConfig;
import spring.Member;
import spring.MemberDao;

public class InsertTemplateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class, DbQueryConfig.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = new Member("test3", "1111", "강감찬", "aa@aa.com");
		memberDao.insert(member);
	}

}
