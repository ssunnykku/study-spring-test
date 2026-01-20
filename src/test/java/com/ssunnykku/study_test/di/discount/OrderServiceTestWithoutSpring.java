package com.ssunnykku.study_test.di.discount;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OrderServiceTestWithoutSpring {
    @Test
    void 할인_적용_테스트() {
        DiscountPolicy discountPolicy = new RateDiscountPolicy();
        OrderService orderService = new OrderService(discountPolicy);

        int price = 100_000;
        int result = orderService.calculatePrice(price);

        int discountedPrice = price - price / 10;

        assertThat(result).isEqualTo(discountedPrice);
    }

    @Test
    void 고정_할인_적용_테스트() {
        DiscountPolicy discountPolicy = new FixDiscountPolicy();
        OrderService orderService = new OrderService(discountPolicy);

        int price = 100_000;
        int result = orderService.calculatePrice(price);

        int discountedPrice = price - discountPolicy.discount(price);

        assertThat(result).isEqualTo(discountedPrice);

    }
}
