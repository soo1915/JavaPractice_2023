package student;

public class StudentPrinter {

	public void print(Student student) {
		System.out.printf(
				"회원 정보: 아이디=%d, 전화번호=%s, 이름=%s, 등록일=%tF\n", 
				student.getSid(), student.getPhone(),
				student.getName(), student.getRegisterDateTime());
	}
}
