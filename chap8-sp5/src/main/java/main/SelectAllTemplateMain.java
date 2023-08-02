package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQueryConfig;
import spring.MemberDao;

public class SelectAllTemplateMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class, DbQueryConfig.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		System.out.println(memberDao.selectAll());
	}

}
