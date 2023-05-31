package sec02;

public class SignOpEx {

	public static void main(String[] args) {
		float f1 = 0.1f;
		System.out.printf("%.20f\n", f1);

		double d1 = 0.1;
		System.out.printf("%.20f\n", d1);
		
		boolean aa = f1 == (float)d1;
		System.out.println(aa);
		
		
		System.out.println("--------------------------");

		int result = 0;
		result += 10;
		System.out.println("result= " + result);
		result -= 5;
		System.out.println("result= " + result);
		result *= 3;
		System.out.println("result= " + result);
		result /= 5;
		System.out.println("result= " + result);
		result %= 3;
		System.out.println("result= " + result);
		
		System.out.println("--------------------------");
		
		int score = 85;
		char grade = (score > 90) ? 'A' : ((score >80) ? 'B' : 'C');
		System.out.println(score + "점은 "+grade +"등급입니다.");
	}

}
