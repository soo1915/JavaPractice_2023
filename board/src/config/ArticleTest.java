package config;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import article.dao.ArticleDao;

public class ArticleTest {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		ArticleDao articleDao = ctx.getBean("articleDao", ArticleDao.class);
		System.out.println(articleDao.select(1, 1));
//		Writer writer = new Writer("aaa", "홍길동");
//		Article article = new Article(1, writer, "홍길동", new Date(), new Date(), 0);
//		articleDao.insert(article);
//		System.out.println(articleDao.selectCount());
		System.out.println(articleDao.selectById(1));
		
		
		
		
		
//		System.out.println(memberDao.selectCount());
//		Member list = memberDao.selectById("aaa");
//		System.out.println(list);
//		//insert
////		Member member = new Member("bbb", "홍길철", "1111", new Date());
////		memberDao.insert(member);
//		Member member = new Member("bbb", "홍길철", "222", null);
//		memberDao.update(member);
	}

}
