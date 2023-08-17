package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import member.dao.MemberDao;

public class SpringEx1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		System.out.println(memberDao.selectCount());

	}

}
