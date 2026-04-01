package commerce;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 커머스 플랫폼의 메인 시스템 클래스
 */
public class CommerceSystem {
    // 속성
    private List<Category> categories = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private Cart cart = new Cart();
    private CartHandler cartHandler = new CartHandler(cart, scanner);
    private AdminHandler adminHandler = new AdminHandler(categories, scanner);
    private Customer customer= new Customer("남동엽","admin123@gmail.com","Platimun");

    /**
     * 카테고리의 상품 목록을 초기화한다.
     * 전자제품, 의류, 식품 카테고리와 각 상품을 생성한다
     */
    public CommerceSystem () {
        // 생성자
        Category electronics = new Category("전자제품");
        electronics.addProduct(new Product("Galaxy S24", 1200000, "최신 스마트폰", 50));
        electronics.addProduct(new Product("ipone 16", 1350000, "apple의 최신 스마트폰",30));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 35 ));
        electronics.addProduct(new Product("AirPods pro",350000, "노이즈 캔슬링 무선 이어폰", 35));
        categories.add(electronics);

        Category clothing = new Category("의류");
        clothing.addProduct(new Product("노스페이스 잠바", 3200000,"겨울용 잠바", 13));
        clothing.addProduct(new Product("나이키 운동화",320000, "스포츠 신발",28));
        clothing.addProduct(new Product("아이다스 티셔츠",235000, "캐쥬얼 티셔츠",76));
        clothing.addProduct(new Product("무신사 바지",87000,"스타일 바지",187));
        categories.add(clothing);

        Category food = new Category("음식");
        food.addProduct(new Product("신라면", 1500,"매콤한 라면",200));
        food.addProduct(new Product("참이슬",1700,"소주",130));
        food.addProduct(new Product("바나나 우유",1200,"빙그레맛 우유",150));
        food.addProduct(new Product("하겐다즈",8800,"프리미엄 아이스크림",50));
        categories.add(food);
    }

    /**
     * 커머스 플랫폼을 시작한다.
     * 메인 메뉴를 출력하고 사용자 입력에 따라 각각의 기능들을 실행한다.
     * 0. 을 입력시 프로그램을 종료한다.
     */
    public void start() {
        while (true){
            System.out.println("[ 실시간 커머스 플랫폼 ]");
            for (int i = 0; i <categories.size(); i++){
                Category c = categories.get(i);
                System.out.println((i + 1) + ". " + c.getName());
            }
            System.out.println("4. 장바구니 확인 | 장바구니 확인 후 주문합니다.");
            System.out.println("5. 주문 취소 | 진행중인 주문을 취소합니다.");
            System.out.println("6. 관리자 모드");
            System.out.println("0. 종료 | 프로그램 종료");
            int input = scanner.nextInt();
            if (input == 0){
                System.out.println("커머스 플랫폼을 종료합니다.");
                break;
            } else if (input == 4) {      // ← 추가
                cartHandler.showCart();
            } else if (input == 5) {      // ← 추가
                cartHandler.resetCart();
            } else if (input == 6) {
                adminHandler.enter();
            } else if (input < 1 || input > categories.size()) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            } else {
                Category selected = categories.get(input -1);
                System.out.println("[ " + selected.getName() + "카테고리 ]");

                for (int i = 0; i<selected.getProducts().size(); i++) {
                    Product p = selected.getProducts().get(i);
                    System.out.println((i + 1) + ". " + p.getName() + " | " + String.format("%,d", p.getPrice()) + "원 | " + p.getDescription());
                }
                System.out.println("0. 뒤로가기");
                int productInput = scanner.nextInt();
                if (productInput == 0) {
                    continue;
                } else if (productInput < 1 || productInput > selected.getProducts().size()) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                } else {
                    Product selectedProduct = selected.getProducts().get(productInput -1);
                    System.out.println("선택한 상품: " + selectedProduct.getName() + " | " + String.format("%,d", selectedProduct.getPrice()) + "원" +" | " + selectedProduct.getDescription() + " | " + selectedProduct.getStock() + "개");
                    System.out.println("이 상품을 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인    2. 취소");
                    int choice = scanner.nextInt();
                    if (choice == 1 ) {
                        cartHandler.addToCart(selectedProduct);
                    }

                }
            }
        }

    }
}
