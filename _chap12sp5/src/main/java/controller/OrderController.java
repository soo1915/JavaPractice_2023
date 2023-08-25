package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import spring.Pizza;

@Controller
@RequestMapping("/order")
@Slf4j
public class OrderController {

	@GetMapping
	public String orderForm(Model model) {
		model.addAttribute("plist", new Pizza());
		return "order/pizzaOrder";
	}
	
	@PostMapping
	public String result(@ModelAttribute("plist") Pizza pizza) {
		log.info("====================="+pizza);
		return "result";
	}
}
