## Spring 테스트 학습

- 테스트 컨테이너 사용 vs 컨테이너 없이 테스트
  - 요구사항: 정책에 따라 할인율 계산
    - 정책1: 주문 금액이 10만원 이상이면 10% 할인해주는 서비스 (RateDiscountPolicy)
    - 정책2: 고정 금액 할인 (FixDiscountPolicy)
