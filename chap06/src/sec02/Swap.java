package sec02;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 10;
		int b = 20;
		int temp = 0;
		// swapData(a, b); call by value
		int tmp = a;
		a = b;
		b = tmp;
		
		
		System.out.printf("A = %d, B = %d\n", a, b);

	}
	
	public static void swapData(int x, int y) {
		int tmp = x;
		x = y;
		y = tmp;
	}

}
