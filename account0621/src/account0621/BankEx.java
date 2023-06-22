package account0621;

import java.util.Scanner;

public class BankEx {
	public static void main(String[] args) {
		boolean run = true;

		AccountServiceImpl service = new AccountServiceImpl();
		int balance = 0;

		Scanner scanner = new Scanner(System.in);
		AccountDto dto = null;
		int accnum = 0;
		do {
			System.out.print("계좌번호> ");
			accnum = Integer.parseInt(scanner.nextLine());
			dto = service.checkAccount(accnum);
			accnum = dto.getAccnum();
			if(accnum == 0) {
				System.out.println("계좌번호를 확인해 주세요.");
				System.out.print("계좌를 생성하시겠습니까?");
				String res = scanner.nextLine();
				if(res.equals("y") || res.equals("yes") || res.equals("Y")) {
					System.out.print("이름 입력>");
					String name = scanner.nextLine();
					if(!name.trim().equals("")) {
						int num = service.createAccount(name);
						System.out.println(name+"님의 계좌번호: "+ num);
					}
					
				}
			}
		} while(accnum == 0);
		

// 계좌번호 확인 메소드 호출
		while (run) {
			System.out.println("-------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("-------------------------------------");
			System.out.print("선택> ");

			int menuNum = Integer.parseInt(scanner.nextLine());

			switch (menuNum) {
			case 1:
				System.out.print("예금액> ");
				balance = Integer.parseInt(scanner.nextLine());
				service.deposit(balance, accnum);
				break;
			case 2:
				System.out.print("출금액> ");
				balance = Integer.parseInt(scanner.nextLine());
				service.withdraw(balance, accnum);
				break;
			case 3:
				System.out.print("잔고> ");
				balance = service.check(accnum);
				System.out.println(balance);
				break;
			case 4:
				run = false;
				break;
			}

			System.out.println();
		}

		System.out.println("프로그램 종료");
	}
}