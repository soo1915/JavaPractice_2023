package static0531;

public class HandleStu {
	public static int index = 0;
	public static Student[] stu = new Student[3];
	public static void create() {
		for (int i = 0; i < stu.length; i++) {
			stu[i] = new Student();
		}
	}
}
