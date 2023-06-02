package sec01;

public class DmbCellPhoneExample {
	public static void main(String[] args) {
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		System.out.println("모델 : " + dmbCellPhone.model); // 부모
		System.out.println("색상 : " + dmbCellPhone.color); // 부모
		System.out.println("채널 : " + dmbCellPhone.channel); 
		
		dmbCellPhone.powerOn(); // 부모
		dmbCellPhone.bell(); // 부모
		dmbCellPhone.sendVoice("여보세요."); // 부모
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요."); // 부모
		dmbCellPhone.sendVoice("아~ 예 반갑습니다."); // 부모
		dmbCellPhone.hangUp(); // 부모
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
	}
}
