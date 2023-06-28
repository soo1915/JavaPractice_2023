package test;

public class Ex4 {

	public static void main(String[] args) {

		int x = 100;
		int y = 200;
		int tmp = 0;
		
		tmp = x;
		x = y;
		y = tmp;
		
		System.out.println(x);
		System.out.println(y);
	}

}
