package core;

import core.member.Grade;
import core.member.Member;
import core.order.Order;

public class MemberApp {

	public static void main(String[] args) {

		AppConfig app = new AppConfig();
		
		Member member = new Member(1L, "홍", Grade.VIP);
		app.memberService().join(member);
		
		Member findMember = app.memberService().findMember(1L);
		System.out.println(findMember.getName());
		
		Order order = app.orderService().createOrder(1L, "item1", 9000);
		System.out.println("할인 금액 : " + order.getDiscountPrice());
		System.out.println("지불 금액 : " + order.calculatePrice());
		
	}

}
