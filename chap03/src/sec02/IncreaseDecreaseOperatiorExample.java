package sec02;

public class IncreaseDecreaseOperatiorExample {

	public static void main(String[] args) {
		int x = 10;
		int y = 10;
		int z ;
		
		System.out.println("-----------");
		x++;
		++x;
		System.out.println("x : " + x);
		
		System.out.println("-----------");
		y--;
		--y;
		System.out.println("y : " + y);

		System.out.println("-----------");
		z = x++;
		System.out.println("z : " + z);
		System.out.println("x : " + x);
		
		System.out.println("-----------");
		z = ++x;
		System.out.println("z : " + z);
		System.out.println("x : " + x);
		
		System.out.println("-----------");
		z = ++x + y++;
		System.out.println("z : " + z);
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		System.out.println("-----------");
		boolean play = true;
		System.out.println(play);
		
		System.out.println("-----------");
		play = !play;
		System.out.println(play);
		
		System.out.println("-----------");
		int x1 = 10;
		int x2=  3;
		System.out.println(x1/x2);
		
	}

}
