package sec02;

import java.util.Scanner;

public class ScoreExample {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("�̸��� �Է��ϼ���: ");
		String name = scanner.nextLine();
		
		System.out.println("���� ���� �Է� : ");
		int kor = Integer.parseInt(scanner.nextLine());

		System.out.println("���� ���� �Է� : ");
		int math = Integer.parseInt(scanner.nextLine());		

		System.out.println("���� ���� �Է� : ");
		int eng = Integer.parseInt(scanner.nextLine());
		
		int sum = kor + math + eng;
		int avg = sum / 3;
		
		char korgrade = ((kor>=90)?'A':(kor>=80)? 'B':'C');
		char mathgrade = ((math>=90)?'A':(math>=80)? 'B':'C');
		char enggrade = ((eng>=90)?'A':(eng>=80)? 'B':'C');
		
		System.out.println();
		System.out.println(name + "���� �����Դϴ�.");
		System.out.println("���� ��� : " + korgrade);
		System.out.println("���� ��� : " + mathgrade);
		System.out.println("���� ��� : " + enggrade);
		System.out.println("���� : " + sum );
		System.out.println("��� : " + avg);
		
		
		
	}

}
