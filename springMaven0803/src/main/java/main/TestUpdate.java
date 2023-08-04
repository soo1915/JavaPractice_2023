package main;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Member;
import spring.MemberDao;

public class TestUpdate {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = new Member("aaa@madvirus.net", "2222", "abc", LocalDateTime.now());
		memberDao.update(member);
	}

}
