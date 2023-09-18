package hello.core.discount;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscountPolicyTest  {
    private static final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 함.")
    void vipTest() {
        // given
        Member vip = new Member(1L, "vip", Grade.VIP);

        // when
        int discount = discountPolicy.discount(vip, 10000);

        // then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 10%할인이 적용되면 안됨.")
    void notVIP() {
        // given
        Member vip = new Member(1L, "basic", Grade.BASIC);

        // when
        int discount = discountPolicy.discount(vip, 10000);

        // then
        assertThat(discount).isEqualTo(0);
    }

}
