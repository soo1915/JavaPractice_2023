package account0621;

public class AccountServiceImpl {
	AccountDao dao = new AccountDao();
	
	int createAccount(String name) {
		int accnum = dao.selectMaxAccount();
		AccountDto dto = new AccountDto(accnum+1, name, 0);
		dao.insert(dto);
		return accnum+1;  // 계좌번호 리턴
	}
	
	AccountDto checkAccount(int num) { // 계좌번호 확인
		AccountDto dto = dao.selectOne(num);
		return dto;
	}
	
	int check(int num) {  // 잔고 확인
		AccountDto dto = dao.selectOne(num);
		return dto.getDeposit();
	}
	
	void deposit(int deposit, int num) { // 예금
		if(deposit >= 1000) { // 비지니스 로직
			dao.update(deposit+check(num), num);
		} else {
			System.out.println("입금 금액 확인 바랍니다.");
		}
		
	}
	void withdraw(int withdraw, int num) { // 출금
		int price = check(num);
		if(price >= withdraw && withdraw >= 10000) {
			dao.update(price - withdraw, num);
		}else {
			System.out.println("출금이 불가합니다.");
		}
	}
}