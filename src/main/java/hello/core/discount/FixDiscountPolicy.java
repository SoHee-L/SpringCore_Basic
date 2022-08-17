package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{ //DiscountPolicy에 대한 구현체를 만듬.

    private  int discountFixAmount = 1000; // 1000원할인

    @Override
    public int discount(Member member, int price) {
        //enum 타입은 ==쓰는게 맞음.
        if(member.getGrade() == Grade.VIP){ //vip면 discountFixAmount로 리턴 천원
            return  discountFixAmount;
        } else {
            return  0; // vip가 아니면 0; 할인 없음.
        }
    }
}
