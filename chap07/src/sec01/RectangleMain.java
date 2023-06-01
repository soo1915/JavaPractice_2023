package sec01;

import java.util.Scanner;

public class RectangleMain {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
	
		Rectangle rect = new Rectangle() ;
		System.out.print("첫번째 수 입력 : ");
		String str = scanner.nextLine();
		int x = Integer.parseInt(str);
		rect.setX(x);
		System.out.print("두번째 수 입력 : ");
		str = scanner.nextLine();
		int y = Integer.parseInt(str);
		rect.setY(y);
		System.out.print(rect.areaRec("넓이 : "));
		System.out.println(rect.areaRec());
		
	}

}
