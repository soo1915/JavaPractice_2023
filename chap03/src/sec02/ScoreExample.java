package sec02;

import java.util.Scanner;

public class ScoreExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("이름을 입력하세요: ");
		String name = scanner.nextLine();
		
		System.out.println("국어 점수 입력 : ");
		int kor = Integer.parseInt(scanner.nextLine());

		System.out.println("수학 점수 입력 : ");
		int math = Integer.parseInt(scanner.nextLine());		

		System.out.println("영어 점수 입력 : ");
		int eng = Integer.parseInt(scanner.nextLine());
		
		int sum = kor + math + eng;
		int avg = sum / 3;
		
		char korgrade = ((kor>=90)?'A':(kor>=80)? 'B':'C');
		char mathgrade = ((math>=90)?'A':(math>=80)? 'B':'C');
		char enggrade = ((eng>=90)?'A':(eng>=80)? 'B':'C');
		
		System.out.println();
		System.out.println(name + "님의 성적입니다.");
		System.out.println("국어 등급 : " + korgrade);
		System.out.println("수학 등급 : " + mathgrade);
		System.out.println("영어 등급 : " + enggrade);
		System.out.println("총점 : " + sum );
		System.out.println("평균 : " + avg);
		
		
		
	}

}
