package chap09;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping("/hello") // url에 작성되는 요청
	public String aaa(Model model, @RequestParam(value = "name", required = false) String name) { // = request.getParameter
		model.addAttribute("greeting", "안녕하세요, " + name);
		return "hello"; // jsp 파일 이름이 return과 같아야 함
	}
	
	@GetMapping("/add")
	public String add() {
		return "addForm";
	}
	
	@GetMapping("/result")
	public String result(Model model, @RequestParam(required = true, defaultValue = "0") Integer num1, 
								      @RequestParam(required = true, defaultValue = "0") Integer num2) {
		model.addAttribute("num1", num1);
		model.addAttribute("num2", num2);
		model.addAttribute("sum", num1 + num2);
		return "result";
	}
	
	
}
