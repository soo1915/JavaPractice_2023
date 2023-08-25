package controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import spring.Join;

@Controller
@RequestMapping("/join")
@Slf4j
public class JoinController {

	@GetMapping
	public String joinForm(Model model) {
		model.addAttribute("join", new Join());
		return "join/register";
	}
	
	@PostMapping
	public String joinExec(@ModelAttribute("join") @Valid Join join, Errors errors) {
		if (errors.hasErrors())
			return "join/register";
		return "join/success";
		
	}
}
