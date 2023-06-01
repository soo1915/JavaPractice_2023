package sec02;

import java.util.Scanner;

public class ForEx1 {

	public static void main(String[] args) {
/*		int num = 0;
		for (int k = 2; k <= 9; k++) {
			System.out.print(k + "��" + "\t");
		}
		System.out.println();
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 2; j <= 9; j++) {
				System.out.print(j + "*" + i + "=" + i*j + "\t");
			}
			System.out.println("");
		}
		//System.out.println(num);
	*/
		
		int i = 0;
		do {
			System.out.println(i);
			i++;
		}
		
		while(i<3);
		
		
		
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		while(run) {
			System.out.println("-------------------");
			System.out.println("1. 예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------");
			System.out.print("선택> ");
			
			int input = scanner.nextInt();
			if (input == 1 ) {
				System.out.print("예금액>");
				int inmoney = scanner.nextInt();
				balance += inmoney;
			} else if (input == 2) {
				System.out.print("출금액>");
				int outmoney = scanner.nextInt();
				balance -= outmoney;
			} else if (input == 3) {
				System.out.println("잔고>" + balance);
			} else {
				System.out.print("프로그램 종료");
				break;
			}
			
		}
		
		
		
			
	
	}
}

