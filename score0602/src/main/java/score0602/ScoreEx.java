package score0602;

import java.util.Scanner;

public class ScoreEx {

	public static void main(String[] args) {
		
		boolean run = true;
		
		Scanner scanner = new Scanner(System.in);
		
		Singleton st = Singleton.getInstance();
		
		for (int i = 0; i < st.students.length; i++) {
			// 임시 자료
			st.students[i].setName("김"+i);
			int score = (int)(Math.random()*100 + 1);
			st.students[i].setKor(score);
			score = (int)(Math.random()*100 + 1);
			st.students[i].setMath(score);
			score = (int)(Math.random()*100 + 1);
			st.students[i].setEng(score);
		}
		
//		for (int i = 0; i < st.students.length; i++) {
//			System.out.print((i+1) + "번 학생 이름 : ");
//			String name = scanner.nextLine();
//			st.students[i].setName(name);
//			// 국어 점수 입력
//			System.out.print((i+1) + "번 국어 점수 : ");
//			int kor = Integer.parseInt(scanner.nextLine());
//			st.students[i].setKor(kor);
//			// 수학 점수 입력
//			System.out.print((i+1) + "번 수학 점수 : ");
//			int math = Integer.parseInt(scanner.nextLine());
//			st.students[i].setMath(math);
//			// 영어 점수 입력
//			System.out.print((i+1) + "번 영어 점수 : ");
//			int eng = Integer.parseInt(scanner.nextLine());
//			st.students[i].setEng(eng);
//		}
		
		
		for (Student student : st.students) {
			System.out.println(student);
		}
		
		while(run) { // 무한루프
			System.out.println("---------------------------------------------------------");
			System.out.println("1. 학생별 총점/평균   2. 과목별 최고 점수/이름   3. 이름 검색   4. 종료");
			System.out.println("---------------------------------------------------------");
			System.out.print("선택 : ");
			int num = Integer.parseInt(scanner.nextLine());
			switch(num) {
			case 1 : 
				System.out.println("이름\t국어\t수학\t영어\t종점\t평균");
				System.out.println("---------------------------------------------------------");
				for (Student student : st.students) {
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%f\n", student.getName(), student.getKor(), student.getMath(), 
							student.getEng(), student.total(), student.avg());
				}
				System.out.println("---------------------------------------------------------");
				break;
			case 2 :
					st.makeKing();
					System.out.println("과목\t이름\t점수");
					System.out.println("---------------------------------------------------------");
					System.out.printf("국어\t%s\t%d\n", st.korKingName, st.korKingScore );
					System.out.printf("수학\t%s\t%d\n", st.mathKingName, st.mathKingScore );
					System.out.printf("영어\t%s\t%d\n", st.engKingName, st.engKingScore );
					System.out.println("---------------------------------------------------------");
				break;
			case 3 : 
				System.out.print("이름 검색 > ");
				String name = scanner.nextLine();
				Student student = st.search(name);
				if (student != null) {
					System.out.println("이름\t국어\t수학\t영어\t종점\t평균");
					System.out.println("---------------------------------------------------------");
					System.out.printf("%s\t%d\t%d\t%d\t%d\t%f\n", student.getName(), student.getKor(), student.getMath(), 
							student.getEng(), student.total(), student.avg());
				}else {
					System.out.println("정보가 없습니다.");
				}
				break;
			case 4 :
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}

}
