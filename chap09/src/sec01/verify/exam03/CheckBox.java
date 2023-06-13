package sec01.verify.exam03;

public class CheckBox {

	static interface OnSelectListener{
		void onSelect();
	}
	
	OnSelectListener listener;

	public void setListener(OnSelectListener listener) {
		this.listener = listener;
	}
	
	void select() {
		listener.onSelect();
	}
	
}
