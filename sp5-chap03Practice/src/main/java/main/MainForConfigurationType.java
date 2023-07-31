package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppConf1;
import config.AppConf2;

class Aaa {}

public class MainForConfigurationType {

	public static void main(String[] args) throws Exception {

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConf1.class, AppConf2.class);
		AppConf1 app1 = ctx.getBean(AppConf1.class);
		System.out.println(app1);

		Aaa a1 = new Aaa();
		System.out.println(a1);
	}

}