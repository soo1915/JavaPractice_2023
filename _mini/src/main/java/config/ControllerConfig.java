package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.BBSController;
import controller.LoginController;
import controller.LogoutController;
import spring.AuthService;

@Configuration
public class ControllerConfig {

	@Autowired
	private AuthService authService;
	
	@Bean
	public LoginController loginController() {
		LoginController loginController = new LoginController();
		loginController.setAuthservice(authService);
		return loginController;
	}
	
	@Bean
	public LogoutController logoutController() {
		return new LogoutController();
	}
	
	@Bean
	public BBSController bbsController() {
		return new BBSController();
	}

}
