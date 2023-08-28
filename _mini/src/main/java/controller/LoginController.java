package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import spring.AuthInfo;
import spring.AuthService;
import spring.WrongIdPasswordException;

@Controller
@RequestMapping("/login")
@Slf4j
public class LoginController {

	private AuthService authService;
	
	public void setAuthservice(AuthService authService) {
		this.authService = authService;
	}
	
	@GetMapping
	public String Form(LoginCommand loginCommand) { // 매개변수를 지우고 아래 문장을 작성하는 것과 동일
		//model.addAttribute("loginCommand", new LoginCommand());
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getId(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			session.setAttribute("test", authInfo);
			// 세션에 autoInfo 저장해야 함
			AuthInfo authInfo1 = (AuthInfo) session.getAttribute("authInfo");
			log.info("======================"+authInfo1);
			return "login/loginSuccess";
		} catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
}
