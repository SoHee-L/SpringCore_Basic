package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder(){
        Long memberId = 1L; //객체생성에서 null이들어갈 수도 있어서 Long사용
        /*long memberId = 1L; 이런식으로 primitive 타입인 long을 써도 상관없지만 primitive타입은 null을 넣을 수 없다.*/

        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOreder(memberId, "itemA", 1000);
        //검증을 sysout으로 하는게 아닌 Assertions로 써야 method 체인...으로해서 편하게 만들 수 있음.
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);

    }
}