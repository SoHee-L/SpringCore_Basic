package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {
        //1. 테스트하기위해
        MemberService memberService = new MemberServiceImpl(); //2. member 서비스와
        OrderService orderService = new OrderServiceImpl(); //2. order 서비스를 만듬.

        Long memberId = 1L; //멤버id는 1이라 설정. 왜냐면 멤버를 저장해야되니까.
        Member member = new Member(memberId, "memberA", Grade.VIP); //vip회원하나 만듬
        memberService.join(member); //메모리객체에 넣어됨. 그래야 주문해서 찾아 쓸 수 있으니까.

        //order서비스에서 createOder를 함. 그럼 order가 생성됨.
        Order order = orderService.createOreder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("order.calculatePrice = " + order.calculatePrice());
    }
}
