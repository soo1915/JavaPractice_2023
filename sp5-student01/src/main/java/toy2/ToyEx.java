package toy2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ToyEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtX.class);
		Toy toy = ctx.getBean("toy", Toy.class);
		while(toy.isBattery()) {
			toy.move();
		}
		System.out.println("연료부족");
	}

}
