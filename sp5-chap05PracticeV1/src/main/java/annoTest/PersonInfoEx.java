package annoTest;

import java.lang.annotation.Annotation;

public class PersonInfoEx {

	public static void main(String[] args) {
		Annotation[] alst = Person.class.getAnnotations();
		for (Annotation ann : alst) {
			PersonInfo personInfo = (PersonInfo) ann;
			System.out.println(personInfo.mention());
		}
	}

}
