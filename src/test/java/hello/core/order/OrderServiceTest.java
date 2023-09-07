package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OrderServiceTest {

    private static final MemberService memberService = new MemberServiceImpl();
    private static final OrderService orderService = new OrderServiceImpl();

    @Test
    void orderServiceTest() {
        Long memberId = 1L;
        Member memberA = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order itemA = orderService.createOrder(memberId, "itemA", 10000);

        Assertions.assertThat(itemA.calculatePrice()).isEqualTo(9000);
    }
}
