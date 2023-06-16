package sec01;

public class SystemTimeExample {

	public static void main(String[] args) {
		
		long time1 = System.nanoTime();
		System.out.println(time1);
		
		for(int i = 0; i<= 1000000000; i++) {}

		long time2 = System.nanoTime();
		System.out.println(time1);
		
		System.out.println(time2 - time1);
		
		
		
	}

}
