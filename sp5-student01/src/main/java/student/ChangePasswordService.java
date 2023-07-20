package student;

public class ChangePasswordService {
	
	// select 하기 위해서 선언
	private StudentDao studentDao;
	
	public void changePassword(String phone, String oldPwd, String newPwd) {
		Student student = studentDao.selectByPhone(phone);
		if (student == null)
			throw new StudentNotFoundException();
		student.changePassword(oldPwd, newPwd);
		studentDao.update(student);
	}
	
	// setter로 주입 후 객체 생성
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
}
