package core;

import core.discount.DiscountPolicy;
//import core.discount.FixDiscountPolicy;
import core.discount.RateDiscountPolicy;
import core.member.MemberRepository;
import core.member.MemberServiceImpl;
import core.member.MemoryMemberRepository;
import core.order.OrderServiceImpl;

public class AppConfig { // 앱 구성 설정, 생성

	public DiscountPolicy discountPolicy() { // 할인 정책 결정
		return new RateDiscountPolicy();
	}
	
	public MemberRepository memberRepository() { // 회원 저장, 검색 기능 생성
		return new MemoryMemberRepository();
	}
	
	public MemberServiceImpl memberService() { // 회원 서비스 기능 생성
		return new MemberServiceImpl(memberRepository());
	}
	
	public OrderServiceImpl orderService() { // 주문 서비스 기능 생성
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
}
