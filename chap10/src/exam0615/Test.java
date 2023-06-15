package exam0615;

public class Test {

	private int x;

	public int getX() {
		return x;
	}

	public void setX(int x) throws TestException {
		if (x < 0) {
			throw new TestException("x는 0보다 커야 합니다.");// 예외를 발생시키는 명령어
		}
		this.x = x;
	}
	
	
}
