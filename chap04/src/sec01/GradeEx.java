package sec01;

import java.util.Scanner;

public class GradeEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String inputData;
		int score;
		
		System.out.println("���� �Է�>");
		inputData = scanner.nextLine();
		score = Integer.parseInt(inputData);
		int num = score/10;
		switch(num) {
		case  10 : 
			System.out.println("A ����");
			break;
		case  9 : 
			System.out.println("A ����");
			break;
		case  8 : 
			System.out.println("B ����");
			break;
		case  7 : 
			System.out.println("C ����");
			break;
		default :
			System.out.println("F ����");
		}
		
	}

}
