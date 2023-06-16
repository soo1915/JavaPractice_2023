package sec01.verify.exam03;

import java.util.Objects;

public class Student {

	private String studentNum;
	
	public Student(String studentNum) {
		this.studentNum = studentNum;
	}
	
	public String getStudentNum() {
		return studentNum;
	}

	@Override
	public int hashCode() {
		return studentNum.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student compareStu = (Student) obj;
			if(studentNum.equals(compareStu.getStudentNum())) {
				return true;
			}
			
		}
		return false;
	}
	
	
}
