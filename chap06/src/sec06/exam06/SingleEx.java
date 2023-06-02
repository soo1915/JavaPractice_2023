package sec06.exam06;

public class SingleEx {

	public static void main(String[] args) {

		Singleton a1 = Singleton.getSt();
		
		Singleton a2 = Singleton.getSt();
		
		for(int i=0; i<10; i++) {
			System.out.println(a2.index);	
		}
				
	}

}
