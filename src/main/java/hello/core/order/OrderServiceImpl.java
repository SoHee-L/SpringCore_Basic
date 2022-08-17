package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    //OrderService는 2개가 필요. memberRepository 찾아야되니까 필요 그리고 할인정책

    //orderService 입장에서 할인은 모름. 할인은 잘모르겠고 결과만 알아서 던져줘. 라고 설계.
    //=> 즉 단일체계원칙을 잘 지킴. 만약에 할인에 대한 변경이 필요하면 할인 쪽만 고치면 되니까
    //만일 단일체계원칙이 잘 설계되지 않고 discountPolicy가 없었다면. orderService에서 할인과 관련된 변경이 들어와도 orderService에서 고쳐야되는 문제가 생김.
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();//고정할인 정책

    @Override //1. 주문생성 요청
    public Order createOreder(Long memberId, String itemName, int itemPrice /*input*/) {
        Member member = memberRepository.findById(memberId); //member찾아야되서 찾음. 2. 먼저 조회
        int discountPrice = discountPolicy.discount(member /*이부분에 대해선 고민하면됨. Grade를 넘길까, member자체를 넘길까.*/, itemPrice); //3. 할인 정책에 회원(member)을 넘김

        return new Order(memberId, itemName, itemPrice, discountPrice /*output*/); //최종생성된 주문 반환.
        //Order 주문을 만들어서 반환 해주기만 하면 orderService의 역활이 끝남.
    }
}
