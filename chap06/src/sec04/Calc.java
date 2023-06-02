package sec04;

public class Calc {
	int plus(int x, int y) {
		
		int result = x + y;
		System.out.println("plus 실행 후 리턴값" + result);
		return result;
		
	}
	
	double avg(int x, int y) {

		double sum = plus(x, y);
		double result = sum / 2;
		System.out.println("avg 실행 후 리턴값" + result);
		return result;
	}
	
	void execute() {
		System.out.println("execute");
		double result = avg(7, 10) ;
		println("실행결과 : " + result);
	}
	
	void println(String message) {
		System.out.println("println");
		System.out.println(message);
	}
}
