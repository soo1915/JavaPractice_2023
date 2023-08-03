package main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.Member;
import spring.MemberDao;

public class TestSelAll {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		List<Member> list = memberDao.selectAll();
		for (Member member : list) {
			System.out.println(member);
		}
	}

}
