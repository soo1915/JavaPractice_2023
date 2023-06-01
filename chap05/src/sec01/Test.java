package sec01;

public class Test {

	public static void main(String[] args) {
		int[] scores = {10, 20, 30};

		
		for(int i = 0; i<3; i++) {
			if (scores[i] == 10) {
				System.out.println(scores[i]);	
			}
			
		}
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		String name3 = new String("홍길동");
		
		
		if (name1 == name2 ) {
			System.out.println("같다");
		}else {
			System.out.println("다르다");
		}
	}

}
