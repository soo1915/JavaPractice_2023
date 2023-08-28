package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import spring.AuthInfo;

@Controller
@Slf4j
public class LogoutController {

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
		log.info("======================"+authInfo);
		
		session.invalidate();
		
		return "redirect:/main";
	}
}
