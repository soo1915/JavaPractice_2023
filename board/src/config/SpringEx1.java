package config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import member.dao.MemberDao;
import member.model.Member;

public class SpringEx1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		MemberDao memberDao = ctx.getBean("memberDao", MemberDao.class);
		System.out.println(memberDao.selectCount());
		Member list = memberDao.selectById("aaa");
		System.out.println(list);
		//insert
//		Member member = new Member("bbb", "홍길철", "1111", new Date());
//		memberDao.insert(member);
		Member member = new Member("bbb", "홍길철", "222", null);
		memberDao.update(member);
	}

}
