package sec01;

import java.util.Objects;

public class Member {

	String id;
	public Member() {
		
	}
	Member(String id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member) obj;
			if (id.equals(member.id)) {
				return true;
			}
		}
		return false;
	}

	
	
}
