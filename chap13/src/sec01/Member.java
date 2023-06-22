package sec01;

public class Member {

	public String name;
	public int age;
	
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		System.out.println("1");
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("2");
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age) ;
		} else {
			return false;
		}

	}
	
	
}
