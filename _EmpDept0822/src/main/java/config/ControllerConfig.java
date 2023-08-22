package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.EmpController;

@Configuration
public class ControllerConfig {
	
	@Bean
	public EmpController empController() {
		return new EmpController();
	}
	
}
