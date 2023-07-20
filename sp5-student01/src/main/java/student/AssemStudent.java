package student;

import lombok.Getter;

@Getter
public class AssemStudent {

	private StudentDao studentDao;
	private StudentRegisterService regSvc;
	private ChangePasswordService pwdSvc;
	
	public AssemStudent() {
		studentDao = new StudentDao();
		regSvc = new StudentRegisterService(studentDao); // 생성자 주입
		pwdSvc = new ChangePasswordService(); // setter 주입
		pwdSvc.setStudentDao(studentDao); // setter 방식으로 주입하는 것이 성능이 더 좋음
	}
	
//	public StudentDao getStudentDao() {
//		return studentDao;
//	}
//	
//	public StudentRegisterService getStudentRegisterService() {
//		return regSvc;
//	}
//	
//	public ChangePasswordService getChangePasswordService() {
//		return pwdSvc;
//	}
}
