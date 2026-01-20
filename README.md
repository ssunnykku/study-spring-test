## Spring 테스트 학습

- 테스트의 목적과 복잡도에 따른 DI 방식
  - 요구사항: 정책에 따라 할인율 계산
    - 정책1: 주문 금액이 10만원 이상이면 10% 할인해주는 서비스 (RateDiscountPolicy)
    - 정책2: 고정 금액 할인 (FixDiscountPolicy)
