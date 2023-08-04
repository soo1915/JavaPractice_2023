package main;

import java.time.LocalDateTime;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Member;
import spring.MemberDao;

public class TestGetKey {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		Member member = new Member("bbb@madvirus.net", "1122", "aaa", LocalDateTime.now());
		memberDao.insert(member);
		System.out.println(member.getId());
	}

}
