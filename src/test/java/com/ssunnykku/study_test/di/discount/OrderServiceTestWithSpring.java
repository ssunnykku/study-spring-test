package com.ssunnykku.study_test.di.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TestConfig.class)
public class OrderServiceTestWithSpring {

    @Autowired
    OrderService orderService;
    @Autowired
    DiscountPolicy discountPolicy;

    @Test
    void 할인_적용_테스트() {
        int price = 100_000;
        int result = orderService.calculatePrice(price);

        // assertThat(result).isEqualTo(90_000);
        assertThat(result).isEqualTo(price - discountPolicy.discount(price));
    }

}
