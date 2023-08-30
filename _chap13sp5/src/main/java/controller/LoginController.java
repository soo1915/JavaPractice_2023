package controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
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
	public String Form(LoginCommand loginCommand, @CookieValue(value = "REMEMBER", required = false) Cookie rCookie) { // 매개변수를 지우고 아래 문장을 작성하는 것과 동일
		//model.addAttribute("loginCommand", new LoginCommand());
		if (rCookie != null) {
			loginCommand.setEmail(rCookie.getValue());
			loginCommand.setRememberEmail(true);
		}
		return "login/loginForm";
	}
	
	@PostMapping
	public String submit(LoginCommand loginCommand, Errors errors, HttpSession session, HttpServletResponse response) {
		new LoginCommandValidator().validate(loginCommand, errors);
		if (errors.hasErrors()) {
			return "login/loginForm";
		}
		try {
			AuthInfo authInfo = authService.authenticate(loginCommand.getEmail(), loginCommand.getPassword());
			session.setAttribute("authInfo", authInfo);
			session.setAttribute("test", authInfo);
			// 세션에 authInfo 저장해야 함
			
			Cookie rememberCookie = new Cookie("REMEMBER", loginCommand.getEmail());
			rememberCookie.setPath("/"); // 쿠키 저장 경로(기억 못하니까 그냥 root로 저장)
			if (loginCommand.isRememberEmail()) {// 이메일 기억하기를 선택했는지 여부
				rememberCookie.setMaxAge(60 * 60 * 24 * 30); //30일 동안 유지되는 쿠키 생성
			} else {
				rememberCookie.setMaxAge(0); //바로 삭제되는 쿠키 생성
			}
			response.addCookie(rememberCookie);
//			AuthInfo authInfo1 = (AuthInfo) session.getAttribute("authInfo");
//			log.info("======================"+authInfo1);
			return "login/loginSuccess";
		} catch(WrongIdPasswordException e) {
			errors.reject("idPasswordNotMatching");
			return "login/loginForm";
		}
	}
}
