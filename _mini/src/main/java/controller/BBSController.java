package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import spring.BBSNotFoundException;
import spring.SimpleBBS;
import spring.SimpleBBSDao;
import spring.UserDao;

@Controller
@Slf4j
public class BBSController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private SimpleBBSDao simpleBBSDao;
	
	@GetMapping("/list")
	public String root(Model model) {
		model.addAttribute("list", simpleBBSDao.selectList());
		return "board/list";
	}
	
	@PostMapping("/view")
	public String view(@RequestParam(value = "id", defaultValue = "0") Integer id, Model model) {
		SimpleBBS sbbs = null;
		try {
			sbbs = simpleBBSDao.view(id);
		} catch(BBSNotFoundException e) {
			log.error("================"+e.getMessage());
		}
		model.addAttribute("dto", sbbs);
		return "board/view";
	}
}
