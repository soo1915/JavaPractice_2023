package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.HelloController;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;
	
	@Bean
	public HelloController helloController() {
		return new HelloController();
	}
	
	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
}
