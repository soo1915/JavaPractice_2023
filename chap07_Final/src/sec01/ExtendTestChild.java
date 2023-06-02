package sec01;

public class ExtendTestChild extends ExtendTest{

	

	String object;
	int x; // 판매할 물건1의 가격입니다.
	int y; // 판매할 물건2의 가격입니다.
	
	ExtendTestChild (String name, int num) {
		super(num, name);
	}
	
	@Override
	String name (String object) {
		System.out.println("자식 객체의 name() 실행 " + object);
		return name;
	}

	void carrotMarket() {
		System.out.printf("%s님 안녕하세요! 당근마켓에 오신 것을 환영합니다. 판매할 물건을 %d개 올려주세요.\n", name, num);
		System.out.printf("판매할 물건1: %s, 가격: %s\n", object, x);
		System.out.printf("판매할 물건2: %s, 가격: %s\n", object, y);
	}

	int carrotTot() {
		System.out.println("총 가격은 다음과 같습니다.");
		int tot = x + y;
		return tot;
	}
}
