package sec01;

class Aaa {
	
}

public class Ppp {
	
	int x;

	void aaa() {}
}

class Ccc extends Ppp{
	Ccc(int x) {
		this.x = x;
		super.aaa();
	}
}
