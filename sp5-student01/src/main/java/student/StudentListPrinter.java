package student;

import java.util.Collection;

public class StudentListPrinter {

	private StudentDao studentDao;
	private StudentPrinter printer;
	
	public StudentListPrinter(StudentDao studentDao, StudentPrinter printer) {
		this.studentDao = studentDao;
		this.printer = printer;
	}
	
	public void printAll() {
		Collection<Student> students = studentDao.selectAll();
		students.forEach(m -> printer.print(m));
	}
}
