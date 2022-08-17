package hello.core.member;

public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //가입을 하고 회원을 찾으려면 memberRepository 인터페이스가 필요 But 인터페이스만 가지고 있으면 널포인트에러가 난다.
    //구현체가 없이 널이면 터짐.그래서 구현객체를 선택해줘야됨.(앞에서 만들었던 new MemoryMemberRepository();)

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        //join에서 save를 호출하면 다형성에 의해서 MemoryMemberRepository();에있는 MemberRepository(인터페이스가 아니라)
        //MemoryMemberRepository();에 있는 save(Member member)가 호출이된다. Override한게.

    }

    @Override
    public Member findMemeber(Long memberId) {
        return memberRepository.findById(memberId);
    }
    //관례같은건데 구현체가 하나만 있으면 인터페이스명뒤에 임플이라고 관례상 많이 쓴다.
}
