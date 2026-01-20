package com.ssunnykku.study_test.di.discount;

public class FixDiscountPolicy implements DiscountPolicy {

    @Override
    public int discount(int price) {
        return 5_000;
    }

}
