package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import spring.Emp;
import spring.EmpDao;

@Controller
@RequestMapping("/emp")
@Slf4j
public class EmpDeptController {

	@Autowired
	private EmpDao empDao;
	
	@GetMapping
	public String empForm(Model model) {
		model.addAttribute("emp", new Emp());
		model.addAttribute("deptList", empDao.selectDept());
		model.addAttribute("empList", empDao.selectEmp());
		return "writeEmpForm";
	}
	
	@PostMapping
	public String empFormSuccess(@ModelAttribute Emp emp) {
		log.info("입력받은 emp객체:" + emp);
		int ret = empDao.insert(emp);
		if (ret == 1) {
			log.info("==========입력 완료==========");
		}
		return "empResult";
	}
}
