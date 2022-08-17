package hello.core.order;

public interface OrderService {
    //클라이언트는 주문을 생성할때 Create 회원 id, 주문명, 주문가격 parameter로 넘기면 return으로 주문결과를 반환하는 부분.
    Order createOreder(/*input값*/Long memberId, String itemName, int itemPrice);
}
