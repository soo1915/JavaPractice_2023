package sec06.exam06;

public class Singleton {
	
	private static Singleton st = new Singleton();
	
	int index;
	
	private Singleton() {}

	public static Singleton getSt() {
		return st;
	}
	
	
}
