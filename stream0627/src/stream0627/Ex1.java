package stream0627;

import java.util.Arrays;
import java.util.List;

class Student {
	String name;
	int score;
	
	public Student(String name, int score) {
		super();
		this.name = name;
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}

public class Ex1 { // 스트림(컬렉션에서만 가능)

	public static void main(String[] args) {

		List<Student> list3 = Arrays.asList(
			new Student("홍길동", 82),
			new Student("홍길순", 92),
			new Student("홍길철", 89)
		);
		list3.stream().forEach(x -> {
			System.out.println(x.getName());
			System.out.println(x.getScore());
			
		});
		
		int sum = 0;
		double av = 0.0;
		for(Student n : list3) {
			sum += n.getScore();
			av = (double) sum / list3.size();
			
		}
		System.out.println(av);
		
		
		double avg = list3.stream().mapToInt(Student::getScore).average().getAsDouble();
		System.out.println(avg);
		
		List<String> list2 = Arrays.asList("홍", "김", "이", "박");
		list2.stream().forEach(x -> {
			System.out.println(x);
		});
		
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		list.stream().forEach(
			a -> {System.out.println(a);}
		);
//		for(int s : list) {
//			System.out.println(s);
//		}

	}

}
