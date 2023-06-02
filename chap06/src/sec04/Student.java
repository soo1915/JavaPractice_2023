package sec04;

public class Student {
	String name;
	int kor;
	int eng;
	int math;
	
	
	Student(String name, int kor, int eng, int math){
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
	
	int getTotal() {
		int sum = kor + eng + math;
		return sum;
	}
	
	double getAvg() {
		int sum = getTotal();
		double avg = (double) sum / 3;
		return avg;
	}
	
	void printStudent() {
		System.out.println("----------[결과]----------");
		System.out.println("이름 : " + name);
		System.out.println("국어 점수 : " + kor);
		System.out.println("영어 점수 : " + eng);
		System.out.println("수학 점수 : " + math);
		System.out.println("총점 : " + getTotal());
		System.out.println("평균 : " + getAvg());
	}
	
}
