package commerce;

/**
 * 상품 정보를 나타내는 클래스
 * 상품명, 가격, 설명, 재고를 관리한다.
 */
public class Product {
    private String name;
    private int price;
    private String description;
    private int stock;

    /**
     * 상품 정보를 입력받아 상품객체를 생성한다.
     * @param name 상품명
     * @param price 가격
     * @param description 설명
     * @param stock 재고
     */
    public Product (String name, int price, String description, int stock){
        this.name = name;
        this.price = price;
        this.description = description;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setName(String name) {
        this.name = name;
    }
}
