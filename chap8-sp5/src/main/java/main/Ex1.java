package main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.DbConfig;
import config.DbQuery;
import config.DbQueryConfig;
import spring.Member;

public class Ex1 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(DbConfig.class, DbQueryConfig.class);
		DbQuery dbQuery = ctx.getBean("dbQuery", DbQuery.class);
//		int c1 = dbQuery.count();
//		System.out.println(c1);
		List<Member> list = dbQuery.selectAll();
		for (Member a : list) {
			System.out.println(a);
		}
	}

}
