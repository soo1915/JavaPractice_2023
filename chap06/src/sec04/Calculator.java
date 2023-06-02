package sec04;

public class Calculator {
	
	int x;
	int y;
	
	Calculator(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	void setX(int x) {
		this.x = x;
	}
	
	void setY(int y) {
		this.y = y;
	}
	
	int getX() {
		return x;
	}
	
	int getY() {
		return y;
	}
	
	void powerOn() {
		System.out.println("전원을 켭니다.");
	}
	
	int plus () {
		return x + y;
	}
	
	double divide() {
		return (double) x / (double) y;
	}
	
	void powerOff() {
		System.out.println("전원을 끕니다.");
	}
}
