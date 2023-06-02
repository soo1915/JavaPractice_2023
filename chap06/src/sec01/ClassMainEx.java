package sec01;

public class ClassMainEx {

	public static void main(String[] args) {
		ClassEx classex = new ClassEx();
		
		System.out.println(classex.name);
		
		classex.name = "객체입니다.";
		
		System.out.println(classex.name);
	}

}
