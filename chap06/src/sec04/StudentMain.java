package sec04;

import java.util.Scanner;

public class StudentMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean run = true;
		int count = 0;
		Student[] students = null;
		Scanner scanner = new Scanner(System.in);
		while(run) {
			System.out.println("-------------------");
			System.out.println("1. 학생수 | 2. 점수 입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			if (selectNo == 1) {
				System.out.print("학생수> ");
				count = Integer.parseInt(scanner.nextLine());
				students = new Student[count];
			} else if(selectNo == 2) {
				for(int i = 0; i<students.length; i++) {
					System.out.print("이름>");
					String name = scanner.nextLine();
					System.out.print("국어>");
					int kor = Integer.parseInt(scanner.nextLine());
					System.out.print("영어>");
					int eng = Integer.parseInt(scanner.nextLine());
					System.out.print("수학>");
					int math = Integer.parseInt(scanner.nextLine());
					
					students[i] = new Student(name, kor, eng, math);
				}
			}else if (selectNo == 3) {
				for (int i = 0; i<students.length; i++) {
					System.out.println("----" + students[i].name +"의 점수----");
					System.out.println("국어 : " + students[i].kor);
					System.out.println("영어 : " + students[i].eng);
					System.out.println("수학 : " + students[i].math);
				}
			} else if (selectNo == 4)  {
				for(int i = 0; i<students.length; i++) {
					students[i].printStudent();
				}
			} else {
				run = false;
			}
		
		}
		System.out.println("프로그램 종료");
	}
}
