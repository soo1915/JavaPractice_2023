package oracle0622;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreEx {

	public static void main(String[] args) throws ClassNotFoundException {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);
		
		
		ScoreDao dao = new ScoreDao();
		
		
//		ScoreDto dto1 = new ScoreDto(1, "홍길동", 80, 70, 89);
//		ScoreDto dto2 = new ScoreDto(2, "홍길철", 94, 58, 76);
//		
//		dao.insert(dto1);
//		dao.insert(dto2);
//	
		ScoreServiceImpl service = new ScoreServiceImpl();
//	
//		ScoreDto dto = null;
//		
//		dto = service.showOne(3);
//		System.out.println(dto);
		
		while(run) {
			System.out.println("-------------------");
			System.out.println("1. 학생 등록 | 2. 점수 변경 | 3. 점수 리스트 | 4. 분석 | 5. 종료");
			System.out.println("-------------------");
			System.out.print("선택>");
			
			int selectNo = Integer.parseInt(scanner.nextLine());
			
			if(selectNo == 1) {
				System.out.print("이름 입력 : ");
				String name = scanner.nextLine();
				int newdata = service.createScore(name);
				System.out.println(newdata + "번 데이터가 생성되었습니다.");
			} else if (selectNo == 2) {
				System.out.println("점수 변경을 시작합니다. ");
				System.out.println("수정하실 학생 번호를 입력해주세요 : ");
				int num = Integer.parseInt(scanner.nextLine());
				System.out.println("국어 점수룰 입력해주세요 : ");
				int kor = Integer.parseInt(scanner.nextLine());
				System.out.println("수학 점수룰 입력해주세요 : ");
				int math = Integer.parseInt(scanner.nextLine());
				System.out.println("영어 점수룰 입력해주세요 : ");
				int eng = Integer.parseInt(scanner.nextLine());
				String res = service.updateScore(num, kor, math, eng);
				System.out.println(res);
			} else if (selectNo == 3) {
				String str = service.listScore() + "\n";
				System.out.println(str);
			} else if (selectNo == 4) {
				
			} else {
				run = false;
			}
		}
		
		System.out.println("종료");
		
	}

}
