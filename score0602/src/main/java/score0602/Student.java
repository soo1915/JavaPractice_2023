package score0602;

public class Student {
	private String name;
	private int kor;
	private int math;
	private int eng;
	
	// 총합 메소드
	public int total() {
		return kor + eng + math;
	}
	
	// 평균 메소드
	public double avg() {
		return total() / 3.0;
	}
		
	// 객체나 프린트를 사용할 수 없는 내용을 프린트해서 찍고 싶을 때 object 클래스에 있는 toString 메소드를 오버라이딩 한 후 문자열로 출력
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
	}

	// Singleton.java line 11 때문에 만든 기본 생성자
	public Student() {} 
	
	// 생성자
	public Student(String name, int kor, int math, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	// Getter, Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
}
