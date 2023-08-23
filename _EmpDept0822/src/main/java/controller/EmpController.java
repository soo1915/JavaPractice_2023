package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import spring.Code;
import spring.EmpDao;
import spring.MemberRegistRequest;

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
	
//	@GetMapping("/test1")
//	public ModelAndView test1() {
//		ModelAndView mav = new ModelAndView();
//		mav.addObject("val", "연습");
//		mav.addObject("code", new Code());
//		mav.setViewName("test1");
//		return mav;
//	}
	
	@GetMapping("/test1")
	public String test1(Model model) {
//		List<String> codes = new ArrayList<>();
//		codes.add("일반회원");
//		codes.add("기업회원");
//		codes.add("헤드헌터회원");
//		model.addAttribute("codeTypes", codes);
		List<Code> clist = new ArrayList<Code>();
		Code code = Code.builder().code("10").label("인사부").build();
		clist.add(code);
		code = Code.builder().code("20").label("회계부").build();
		clist.add(code);
		code = Code.builder().code("30").label("영업부").build();
		clist.add(code);
		model.addAttribute("codeTypes", clist);
		model.addAttribute("code", new Code());
		return "test1";
	}
	@PostMapping("/test1")
	public String test2(@ModelAttribute("code") Code code) {
		log.info("====" + code.getCode() + ", " + code.getLabel() + "====");
		return "result1";
	}
	
	@GetMapping("/regos")
	public String regos1(Model model) {
		String[] list = {"윈도우10", "윈도우11", "맥북", "맥미니"};
//		model.addAttribute("osList", Arrays.asList("윈도우10", "윈도우11", "맥북", "맥미니"));
		model.addAttribute("osList", list);
		model.addAttribute("memberRegistRequest", new MemberRegistRequest());
		return "regosForm";
	}
	
	@PostMapping("/regos")
	public String regos2(@ModelAttribute("MemberRegistRequest") MemberRegistRequest mr  ) {
		log.info("=====================" + mr);
		return "regosResult";
	}
}