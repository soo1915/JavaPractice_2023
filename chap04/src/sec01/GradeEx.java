package sec01;

import java.util.Scanner;

public class GradeEx {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String inputData;
		int score;
		
		System.out.println("점수 입력>");
		inputData = scanner.nextLine();
		score = Integer.parseInt(inputData);
		int num = score/10;
		switch(num) {
		case  10 : 
			System.out.println("A 학점");
			break;
		case  9 : 
			System.out.println("A 학점");
			break;
		case  8 : 
			System.out.println("B 학점");
			break;
		case  7 : 
			System.out.println("C 학점");
			break;
		default :
			System.out.println("F 학점");
		}
		
	}

}
