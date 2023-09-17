package hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    private int userB;

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        // ThreadA : A사용자가 1만원 주문
        int userA = statefulService1.order("userA", 10000);
        // ThreadB : B사용자가 2만원 주문
        int userB = statefulService1.order("userB", 20000);

        // ThreadA : 사용자A의 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println(price);

        System.out.println("userA : " + userA + "userB : " + userB);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}