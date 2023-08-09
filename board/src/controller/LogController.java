package controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import member.service.ChangePasswordService;
import member.service.DuplicateIdException;
import member.service.InvalidPasswordException;
import member.service.JoinRequest;
import member.service.JoinService;
import member.service.MemberNotFoundException;

@Controller
public class LogController {
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ChangePasswordService changePwdSvc;
	
	@Autowired
	private JoinService joinService;
	
	@GetMapping("/login.do")
	public String login1() {
		return "loginForm";
	}
	
	@PostMapping("/login.do")
	public String login2(Model model, @RequestParam String id, @RequestParam String password, HttpServletRequest request) {

		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);

		if (id == null || id.isEmpty())
			errors.put("id", Boolean.TRUE);
		if (password == null || password.isEmpty())
			errors.put("password", Boolean.TRUE);

		if (!errors.isEmpty()) {
			return "loginForm";
		}

		try {
			User user = loginService.login(id, password);
			request.getSession(false).setAttribute("authUser", user);
			return "redirect:/index.jsp";
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return "loginForm";
		}
	}
	
	@GetMapping("/logout.do")
	public String logout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		return "redirect:/index.jsp";
	}
	
	@GetMapping("/changePwd.do")
	public String changePwd1() {
		return "changePwdForm";
	}
	
	@PostMapping("/changePwd.do")
	public String changePwd2(Model model, @RequestParam String curPwd, @RequestParam String newPwd, HttpServletRequest req, HttpServletResponse res) {
		User user = (User)req.getSession().getAttribute("authUser");
		
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if (!errors.isEmpty()) {
			return "changePwdForm";
		}
		
		try {
			changePwdSvc.changePassword(user.getId(), curPwd, newPwd);
			return "changePwdSuccess";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return "changePwdForm";
		} catch (MemberNotFoundException e) {
			try {
				res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
	}
	
	@GetMapping("/join.do")
	public String join1() {

		return "joinForm";
	}
	
	@PostMapping("/join.do") 
	public String join2(Model model, HttpServletRequest req) {
		JoinRequest joinReq = new JoinRequest();
		joinReq.setId(req.getParameter("id"));
		joinReq.setName(req.getParameter("name"));
		joinReq.setPassword(req.getParameter("password"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		
		Map<String, Boolean> errors = new HashMap<>();
		model.addAttribute("errors", errors);
		
		joinReq.validate(errors);
		
		if (!errors.isEmpty()) {
			return "joinForm";
		}
		
		try {
			joinService.join(joinReq);
			return "joinSuccess";
		} catch (DuplicateIdException e) {
			errors.put("duplicateId", Boolean.TRUE);
			return "joinForm";
		}
	}
}
