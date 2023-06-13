package sec01.verify.exam03;

public class CheckEx {

	public static void main(String[] args) {
		
		CheckBox checkBox = new CheckBox();
		checkBox.setListener(new BackgroundChangeListener());
		checkBox.select();
	}

}
