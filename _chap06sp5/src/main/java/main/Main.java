package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import config.AppCtx;
import spring.Client;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Client client = ctx.getBean(Client.class);
		client.send();
		
		ctx.close(); // destroy 메소드는 close와 관계가 있음 (close 실행 시 메소드 실행)
	}

}
