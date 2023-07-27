package toy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ToySpring {

	public static void main(String[] args) {

		ApplicationContext ctx = new AnnotationConfigApplicationContext();
		Toy toy = ctx.getBean("toy", Toy.class);
		
		while(toy.isBattery()) {
			toy.move();
		}
		
		System.out.println("배터리 부족으로 멈춤");
		
	}

}
