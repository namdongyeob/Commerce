package commerce;


import java.util.ArrayList;
import java.util.List;

/**
 *  카테고리 정보를 나타내는 클래스
 *  카테고리명과 해당 카테고리의 상품 목록을 관리한다.
 */
public class Category {
    private String name;
    private List<Product> products;

    /**
     * 카테고리명을 받아 카테고리 객체를 생성한다.
     * @param name 카테고리명
     */
    public Category (String name){
        this.name = name;
        this.products = new ArrayList<>();
    }

    /**
     * 카테고리에 상품을 추가한다.
     * @param product 추가할 상품
     */
    public void addProduct(Product product){
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setName(String name) {
        this.name = name;
    }
}
