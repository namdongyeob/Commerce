package commerce;

import java.util.ArrayList;
import java.util.List;

// 장바구니 전체를 관리하는 클래스
public class Cart {

    private List<CartItem> items;

    // 생성자: 빈 장바구니로 시작
    public Cart() {
        this.items = new ArrayList<>(); // 빈 리스트로 초기화
    }
    // 장바구니에 상품 추가
    public void addItem(Product product, int quantity) {
        for (CartItem item : items) { // items를 하나씩 꺼내서 확인 (이미 담긴 상품인지 체크)
            if (item.getProduct() == product) { // 같은 상품이 이미 있으면
                item.addQuantity(quantity); // 새 항목 추가 대신 수량만 증가
                return; // 찾았으니까 더 볼 필요 없이 바로 종료
            }
        }
        items.add(new CartItem(product, quantity)); // 없는 상품이면 새 항목 추가
    }

    public List<CartItem> getItems() {
        return items; // 장바구니 항목 목록 반환
    }

    // 장바구니 전체 금액 합계
    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : items) { // 모든 항목을 하나씩 꺼내서
            total += item.getTotalPrice(); // 각 항목 금액 누적 (가격 x 수량)
        }
        return total;
    }

    // 장바구니 비우기 - 주문 완료 후 초기화할 때 사용
    public void clear() {
        items.clear();
    }

    // 장바구니 내용 출력 - 상품명 | 가격 | 수량 형식
    public void printCart() {
        for (CartItem item : items) { // 담긴 항목 수만큼 반복
            System.out.println(
                    item.getProduct().getName() + " | " + String.format("%,d", item.getProduct().getPrice()) + "원 | 수량: " + item.getQuantity() + "개"
            );
        }
    }
}