package com.ssunnykku.study_test.di.discount;

public class OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int calculatePrice(int price) {
        return price - discountPolicy.discount(price);
    }
}
