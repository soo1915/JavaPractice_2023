package static0531;

public class Singleton {
	private static Singleton st = new Singleton();
	public Student[] stu = new Student[3];
	
	private Singleton() {
		for (int i = 0; i < stu.length; i++) {
			stu[i] = new Student();
		}
	}
	
	public static Singleton getInstance() {
		return st;
	}
}
