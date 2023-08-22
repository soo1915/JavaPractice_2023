package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/test")
@Slf4j
public class MyController {
	
	@GetMapping
	public String test1() {
		return "testForm";
	}
	
	@PostMapping
	public String test2(@RequestParam String nn) {
		log.info("********************************"+nn+"********************************");
		return "result";
	}
}
