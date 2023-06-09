package sec01.exam01;

public interface Aaa {

	static final int x = 100; // 상수 : 변경이 안되는 값
 
//	Aaa() {} 기본 생성자도 없음 => 생성 자체가 불가
	
//	void method3() {} 메소드 정의도 불가
	
	public abstract void method4(); // public abstract는 생략 가능
	
}

interface Caa {
	void method5();
}

//class Baa implements Aaa, Caa {
//
//	
//}
