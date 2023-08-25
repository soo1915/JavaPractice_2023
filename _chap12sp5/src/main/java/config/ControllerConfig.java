package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.JoinController;
import controller.MyController;
import controller.OrderController;
import controller.RegisterController;
import spring.MemberRegisterService;

@Configuration
public class ControllerConfig {

	@Autowired
	private MemberRegisterService memberRegSvc;

	@Bean
	public RegisterController registerController() {
		RegisterController controller = new RegisterController();
		controller.setMemberRegisterService(memberRegSvc);
		return controller;
	}
	
	@Bean
	public MyController myController() {
		return new MyController();
	}
	
	@Bean
	public JoinController joinController() {
		return new JoinController();
	}
	
	@Bean
	public OrderController orderController() {
		return new OrderController();
	}
}
