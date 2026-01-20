package com.ssunnykku.study_test.di.discount;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    DiscountPolicy discountPolicy() {
        // return new RateDiscountPolicy();
        return new FixDiscountPolicy();
    }

    @Bean
    OrderService orderService() {
        return new OrderService(discountPolicy());
    }

}
