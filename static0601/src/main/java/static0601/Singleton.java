package static0601;

public class Singleton {
	
	public Student[] stu = new Student[3];
	private int index;

	public int getIndex() {
		System.out.println(index);
		return index++ % stu.length;
		
	}

	public void setIndex(int index) {
		this.index = index;
	}

	private static Singleton st = new Singleton();
	private Singleton() {
		for (int i = 0; i < stu.length; i++) {
			stu[i] = new Student();
		}
	} 
	
	public static Singleton getInstance() {
		return st;
	}
	
	
}
