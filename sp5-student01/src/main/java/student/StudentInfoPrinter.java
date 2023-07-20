package student;

public class StudentInfoPrinter {

	private StudentDao stuDao;
	private StudentPrinter printer;
	
	public void printStudentInfo(String phone) {
		Student student = stuDao.selectByPhone(phone);
		if (student == null ) {
			System.out.println("데이터 없음\n");
			return;
		}
		printer.print(student);
		System.out.println();
	}
	
	public void setStudentDao(StudentDao studentDao) {
		this.stuDao = studentDao;
	}
	
	public void setPrinter(StudentPrinter printer) {
		this.printer = printer;
	}
}
