package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MyController {

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
}
