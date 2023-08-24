package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import spring.Member;
import spring.MemberDao;

@Controller
@RequestMapping("/validate")
@Slf4j
public class MyController {

	@Autowired
	private MemberDao memberDao;
	
	@GetMapping
	public String form(Model model) {
		model.addAttribute("person", new Person());
		return "form";
	}
	
	@PostMapping
	public String result(Person person, Errors errors) {
		new PersonValidator().validate(person, errors);
		if (errors.hasErrors()) {
			return "form";
		}
		
		log.info("------------------"+person);
		Member member = memberDao.selectByEmail(person.getEmail());
		if (member != null) {
			System.out.println("dup email " + person.getEmail());
			errors.rejectValue("email", "duplicate");
			return "form";
		}
		
		return "result";
	}
}
