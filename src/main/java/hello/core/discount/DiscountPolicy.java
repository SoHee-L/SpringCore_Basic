package hello.core.discount;

import hello.core.member.Member;

public interface DiscountPolicy {

    /**
     * @return 할인 대상 금액
     * 이걸 호출하면 결과로 할인된 금액을 리턴해줌.
     * DiscountPolicy에 대한 구현체를 만든게 FixDiscountPolicy
     */
    int discount(Member member, int price);
}
