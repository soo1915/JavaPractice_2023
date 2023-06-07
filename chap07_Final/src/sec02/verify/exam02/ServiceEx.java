package sec02.verify.exam02;

public class ServiceEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Controller controller = new Controller();	
		
		controller.setService(new MemberService());
		controller.service.login();
		
		controller.setService(new AService());
		controller.service.login();
	}

}
