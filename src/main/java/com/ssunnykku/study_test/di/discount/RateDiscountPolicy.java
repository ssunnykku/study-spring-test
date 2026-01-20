package com.ssunnykku.study_test.di.discount;

public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return price >= 100_000 ? price / 10 : 0;
    }
}