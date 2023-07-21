package toy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ToyEx2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		Toy toy = ctx.getBean("toy", Toy.class);
		Battery battery = ctx.getBean("battery", Battery.class);
		while(toy.isBattery()) {
			toy.move();
		}
		toy.setBattery(battery);

		System.out.println("배터리 부족으로 멈춤");
	}

}
