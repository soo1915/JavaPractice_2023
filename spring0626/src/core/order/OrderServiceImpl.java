package core.order;

import core.discount.DiscountPolicy;
import core.member.Member;
import core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

	private MemberRepository memberRepository; // 회원 정보
	private DiscountPolicy discountPolicy; // 할인 정책

	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		super();
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		return new Order(memberId, itemName, itemPrice, discountPrice);
	}
	
}
