package sec01;

public class StudentExample {

	public static void main(String[] args) {
		Student student = null; // 클래스 변수 선언
		 
		System.out.println(student);
		student = new Student(); // 객체 생성
		System.out.println(student.name);
		student.name = "이순신" ; 
		System.out.println(student.name);
		student.printName();
	}

}
