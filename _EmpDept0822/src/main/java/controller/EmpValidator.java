package controller;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;
import spring.Emp;
import spring.EmpDao;

@Slf4j
public class EmpValidator implements Validator {
	
	EmpDao empDao;
	
	public EmpValidator(EmpDao empDao) {
		this.empDao = empDao;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return Emp.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Emp emp = (Emp) target;
		Emp emp1 = empDao.selectOne(emp.getMgr());
		log.info("-------------------"+emp.getDeptno()+","+emp1.getDeptno());
		log.info("-------------------"+empDao.selectDept(emp1.getEmpno()));
		if (emp.getDeptno() != emp1.getDeptno()) {
			//errors.rejectValue("deptno", "mgr.deptno");
			errors.rejectValue("deptno", "zzzz", empDao.selectDept(emp1.getEmpno())+"를 선택하세요");
		}
		
		
	}

}
