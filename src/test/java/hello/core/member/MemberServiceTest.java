package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){ //given 이런게 주어졌을때 when 언제 then 이렇게 된다라는 의미.
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMemeber = memberService.findMemeber(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMemeber); //member는 findMember랑 똑같냐고 물어보는 것.

    }
}
