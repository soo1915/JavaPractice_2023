package score0602;

public class Singleton {
	
	public String korKingName;
	public String mathKingName;
	public String engKingName;
	public int korKingScore;
	public int mathKingScore;
	public int engKingScore;
	
	
	//과목별 최고점수 / 이름 출력
	public void makeKing() {
		for (Student student : students) {
			if (korKingScore < student.getKor()) {
				korKingScore = student.getKor();
				korKingName = student.getName();
			}
			if (mathKingScore < student.getMath()) {
				mathKingScore = student.getMath();
				mathKingName = student.getName();
			}
			if (engKingScore < student.getEng()) {
				engKingScore = student.getEng();
				engKingName = student.getName();
			}
		}
	}
	
	// 이름 검색 출력
	public Student search(String name) {
		for (Student student : students) {
			if (name.equals(student.getName())){
				return student;
			}
			
		}
		return null;
	}
	
	
	Student[] students = new Student[3]; // 클래스 배열 (데이터 타입)
	
	private static Singleton st = new Singleton(); 
	
	private Singleton() { 
		// 학생 클래스 배열의 객체를 생성
		for (int i = 0; i<students.length; i++) { 
			students[i] = new Student();
		}
	}
	
	

	public static Singleton getInstance() {
		return st;
	}
}
