package sec01;

public class ArrayIndexOutOfBoundExceptionEx {

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("매개값이 부족합니다.");
			System.exit(0);
		}
		String data = args[0];
		String data1 = args[1];
		String data2 = args[2];
		//System.out.println(data);
		System.out.println(args.length);
		// run - run configuration - argument - program arguments
	}

}
