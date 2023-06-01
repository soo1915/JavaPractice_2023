package sec02;

public class Student {
	String name;
	int kor;
	int math;
	int eng;
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", kor=" + kor + ", math=" + math + ", eng=" + eng + "]";
	}

	public Student(String name, int kor, int math, int eng) {
		super();
		this.name = name;
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}




	public static void main(String[] args) {
		
		//String[] arr = {"sdfsdf"};
		Student[] arr = new Student[3];
		arr[0] = new Student("a", 12,23,34);
		arr[1] = new Student("b", 23,34,45);
		arr[2] = new Student("c", 34,45,56);
		for (int i = 0; i<arr.length; i++) {
			System.out.println(arr[i]);			
		}

		
	}

}
