package commerce;

// 장바구니에 담긴 상품 하나를 나타내는 클래스
public class CartItem {
    // 속성
    private Product product;
    private int quantity;

    // 생성자

    /**
     * 상품과 수량을 받아 장바구니 항목을 생성한다.
     * @param product 담을 상품
     * @param quantity 담음 수량
     */
    public CartItem(Product product, int quantity) {
        this.product = product;   // 받아온 상품 저장
        this.quantity = quantity; // 받아온 수량 저장
    }
    // 기능
    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    // 수량 증가 - 같은 상품을 또 담을 때 새 항목 추가 대신 수량만 올릴 때 사용

    /**
     * 수량을 증가시킨다.
     * 같은 상품을 담을때 사용한다.
     * @param amount 추가할 수량
     */
    public void addQuantity(int amount) {
        this.quantity += amount; // 현재 수량에 amount만큼 더하기 (예: 1개 → 2개)
    }
    // 이 항목의 총 금액 계산 (가격 x 수량)

    /**
     * 항목의 총 금액을 계산한다.
     * @return 상품가격 x 수량
     */
    public int getTotalPrice() {
        return product.getPrice() * quantity;
    }
}