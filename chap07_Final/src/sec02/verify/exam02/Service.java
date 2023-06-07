package sec02.verify.exam02;

class Service {

	public void login() {
		System.out.println("로그인");
	}

}

class MemberService extends Service{
	public void login() {
		System.out.println("멤버 로그인");
	}
}

class AService extends MemberService {
	public void login() {
		System.out.println("A로그인");
	}
}





