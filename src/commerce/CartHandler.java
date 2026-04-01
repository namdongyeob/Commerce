package commerce;

import java.util.Scanner;

// 장바구니 관련 기능을 담당하는 핸들러 클래스
public class CartHandler {

    // 속성
    private Cart cart;
    private Scanner scanner;

    // 생성자
    public CartHandler(Cart cart, Scanner scanner) {
        this.cart = cart;
        this.scanner = scanner;
    }

    // CommerceSystem에서 사용자가 상품을 선택하고 "확인" 눌렀을 때 호출
    public void addToCart(Product product) {
        if (product.getStock() < 1) {
            System.out.println("재고가 부족합니다.");
            return; // 재고 없으면 아래 코드 실행 안 하고 바로 종료
        }
        cart.addItem(product, 1);
        System.out.println(product.getName() + "가 장바구니에 추가되었습니다!"); // 재고가 있으면 장바구니에 1개 추가
    }
    // 메인 메뉴에서 "4. 장바구니 확인" 선택 시 호출
    public void showCart() {
        System.out.println("[ 장바구니 내역 ]");
        cart.printCart(); // Cart에서 만든 출력 메서드 호출
        System.out.println("[ 총 주문 금액 ]");
        System.out.println(String.format("%,d", cart.getTotalPrice()) + "원");
        System.out.println("1. 주문확정 2. 메인으로 돌아가기");
        int input = scanner.nextInt();
        if (input == 1) {
            order(); // 주문 확정 메서드 호출
        }
    }
    // showCart()에서 1. 주문확정 선택 시 호출
    public void order() {
        for (CartItem item : cart.getItems()) {
            // 현재 재고 - 주문 수량 = 남은 재고로 업데이트
            item.getProduct().setStock(item.getProduct().getStock() - item.getQuantity());
        }
        System.out.println("주문이 완료되었습니다! 총 금액: " + String.format("%,d", cart.getTotalPrice()) + "원");
        cart.clear();
    }
}