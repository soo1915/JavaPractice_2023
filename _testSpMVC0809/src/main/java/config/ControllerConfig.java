package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.MyController;

@Configuration
public class ControllerConfig {

//	@Bean
//	public HelloController helloController() {
//		return new HelloController();
//	}
	 
	@Bean
	public MyController myController() {
		return new MyController();
	}
	
	
}
