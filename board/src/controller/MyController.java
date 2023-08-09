package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import auth.service.LoginService;
import member.dao.MemberDao;
import member.model.Member;
import member.service.ChangePasswordService;

@Controller
public class MyController {

	@Autowired
	private MemberDao memberDao;	
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private ChangePasswordService changePasswordService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@GetMapping("/form")
	public String form() {
		return "form";
	}
	
	@PostMapping("/result")
	public String result(Model model, @RequestParam Integer num) {
		List<String> list = new ArrayList<>();
		for (int i = 1; i <= 9; i++) {
			String res = String.format("%d X %d = %d", num, i, num*i);
			list.add(res);
		}
		model.addAttribute("list", list);
		return "result";
	}
	
	@GetMapping("/selectCount")
	public String selectCount(Model model) {
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
//		MemberDao memberDao = ctx.getBean("memberDao" , MemberDao.class);
//		model.addAttribute("selectCount", memberDao.selectCount()) ;
		model.addAttribute("selectCount", memberDao.selectCount());
		return "selectCount";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> list = memberDao.selectAll();
		model.addAttribute("list", list);
		return "selectAll";
	}
	
	@GetMapping("/count") 
	public String countMember() {
//		User user = loginService.login("aaa", "111");
//		System.out.println(user.getId()+","+user.getName());
		changePasswordService.changePassword("aaa", "111", "112");
		return "count";
	}
	
}
