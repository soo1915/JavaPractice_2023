package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import spring.EmpDao;

@Controller
@Slf4j
@RequestMapping("/hello")
public class EmpController {

	@Autowired
	private EmpDao empDao;
	
	@GetMapping
	public String hello(Model model) {
//		log.info("emp 테이블의 레코드 수:"+empDao.selectCount());
//		log.info("dept 테이블의 레코드:"+empDao.selectDept().toString());
		model.addAttribute("list", empDao.selectDept());
		return "/hello";
	}
	
	@PostMapping
	public String input(@RequestParam(defaultValue = "0") Integer deptno) {
		log.info("입력 값: "+deptno);
		return "result";
	}
	
	
}
