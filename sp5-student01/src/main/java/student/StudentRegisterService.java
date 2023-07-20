package student;

import java.time.LocalDateTime;

public class StudentRegisterService {

	private StudentDao studentDao;
	
	// 생성자를 통해 객체 생성한 것을 넣어줌(생성자 주입)
	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	// 일련번호는 Long 타입으로 설정(클래스 타입으로 작성 권장) 
	public Long regist(StudentRequest req) {
		Student student = studentDao.selectByPhone(req.getPhone());
		if(student != null) {
			throw new DuplicationStudentException("dup phone " + req.getPhone());
		}
		// 객체 생성해서 넣어야 하기 때문에 new 해야 함!
		Student newStudent = new Student(req.getPhone(), req.getPasswd(), req.getName(), LocalDateTime.now());
		studentDao.insert(newStudent);
		return newStudent.getSid();
	}
}
