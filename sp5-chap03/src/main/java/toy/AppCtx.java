package toy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

	@Bean
	public Battery battery() {
		return new Battery(10);
	}
	
	@Bean
	public Toy toy() {
		Toy toy = new Toy();
		toy.setBattery(battery());
		return toy;
	}
}
