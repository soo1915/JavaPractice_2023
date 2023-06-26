package core.member;

public class MemberServiceImpl implements MemberService{

	private MemberRepository memberRepository;
	
	@Override
	public void join(Member member) {
	
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		// TODO Auto-generated method stub
		return memberRepository.findById(memberId);
	}

	public MemberServiceImpl(MemberRepository memberRepository) {
		super();
		this.memberRepository = memberRepository;
	}

	
}
