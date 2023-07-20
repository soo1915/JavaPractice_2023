package student;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class StudentDao {

	// 값을 일정하게 발생시키기 위해 static으로 설정
	private static long nextId = 0;
	
	private Map<String, Student> map = new HashMap<>();
	
	public Student selectByPhone(String phone) {
		return map.get(phone);
	}
	
	public void insert(Student student) {
		// nextId는 일련번호(키값 아님)
		student.setSid(++nextId);
		// 키값은 phone 번호, 내용은 객체
		map.put(student.getPhone(), student);
	}
	
	public void update(Student student) {
		map.put(student.getPhone(), student);
	}
	
	public Collection<Student> selectAll() {
		return map.values();
	}
}
