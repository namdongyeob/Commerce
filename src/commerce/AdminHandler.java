package commerce;

import java.util.List;
import java.util.Scanner;
// 관리자 모드를 담당하는 핸들러 클래스
public class AdminHandler {
    // 속성
    private List<Category> categories;
    private Scanner scanner;
    private static final String PASSWORD = "admin123";

    //생성자
    public AdminHandler(List<Category> categories, Scanner scanner) {
        this.categories = categories;
        this.scanner = scanner;
    }
    // 관리자 인증 기능 CommerceSystem에서 6. 관리자 모드 선택시 호출됨

    /**
     * 관리자 인증을 진행한다.
     * 비밀번호 3회 오류시 메인화면으로 돌아간다.
     */
    public void enter(){
        for (int i = 0; i < 3; i++) {
            System.out.println("관리자 비밀번호를 입력하세요: ");
            String input = scanner.next();

            if (input.equals(PASSWORD)) {
                showAdminMenu(); // 비밀번호 맞으면 관리자 메뉴호출
                return;
            }
                System.out.println("비밀번호가 틀렸습니다. 남은 횟수: " + (2 -i) + "회");
        }
        System.out.println("비밀번호 3회 오류~! 메인으로 돌아갑니다.");
    }
    // 관리자 메뉴 보여주고 선택에 따라 기능 실행 메서드

    /**
     * 관리자 모드를 보여준다.
     * 선택에 따라 기능 실행이 가능하다.
     */
    public void showAdminMenu() {
        while (true) {
            System.out.println("[ 관리자 모드 ]");
            System.out.println("1. 상품 추가");
            System.out.println("2. 상품 수정");
            System.out.println("3. 상품 삭제");
            System.out.println("4. 전체 상품 현황");
            System.out.println("0. 메인으로 돌아가기");
            int input = scanner.nextInt();
            scanner.nextLine();

            if (input == 0) break;
            else if (input == 1) addProduct(); // 상품 추가
            else if (input == 2) updateProduct(); // 상품 수정
            else if (input == 3) deleteProduct(); // 상품 삭제
            else if (input == 4) printAllProduct(); // 전체 상품 조회
            }
        }
         //상품 정보 입력받기

    /**
     * 새로운 상품을 카테고리에 추가한다.
     * 카테고리 선택 후 상품명 | 가격 | 재고 를 입력받아 추가한다.
     */
        public void addProduct() {
            for (int i = 0; i < categories.size(); i++) {
                System.out.println((i + 1) + ". " + categories.get(i).getName());
            }
            int categoryInput = scanner.nextInt();
            scanner.nextLine();
            Category selected = categories.get(categoryInput -1);

            System.out.println("상품명을 입력하세요:");
            String name = scanner.nextLine();
            System.out.println("상품의 가격을 입력하세요:");
            int price = scanner.nextInt();
            scanner.nextLine();
            System.out.println("상품의 설명을 입력하세요:");
            String description = scanner.nextLine();
            System.out.println("상품의 재고를 입력하세요:");
            int stock = scanner.nextInt();
            scanner.nextLine();
            // 입력받은 정보로 새 상품 생성 후 카테고리에 추가
            Product product = new Product(name, price, description, stock);
            selected.addProduct(product);
            System.out.println("상품이 성공적으로 추가가 완료되었습니다.");
        }
        // 상품명으로 찾아서 가격,설명,재고 수정

    /**
     * 기존 상품 정보를 수정한다
     * 상품명으로 검색 후 가격 | 설명 | 재고 중 선택하여 수정한다
     */
    public void updateProduct() {
            System.out.println("수정할 상품명을 입력하세요:");
            String input = scanner.nextLine();
            Product target = null;
            for (Category category : categories){
                for (Product product : category.getProducts()) {
                    if (product.getName().equals(input)) {
                        target = product;
                    }
                }
            }
            if (target == null) {
                System.out.println("존재하지 않은상품입니다. ");
                return;
            }
            System.out.println("현재 상품 정보: " + target.getName() + " | " + String.format("%,d", target.getPrice()) + "원 | " +
                    target.getDescription() + " | 재고: " + target.getStock() + "개");

            System.out.println("수정할 항목을 선택하세요:");
            System.out.println("1.가격 2.설명 3.재고수량");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice == 1){
                System.out.println("수정할 가격을 입력하세요: ");
                target.setPrice(scanner.nextInt()); // setter로 변경
                scanner.nextLine();
            } else if (choice == 2) {
                System.out.println("수정할 설명을 입력하세요: ");
                target.setDescription(scanner.nextLine()); // setter로 변경
            } else if (choice == 3) {
                System.out.println("수정할 재고수량을 입력하세요: ");
                target.setStock(scanner.nextInt()); // setter로 변경
                scanner.nextLine();
            }
            System.out.println("수정이 완료되었습니다!");
        }
        // 상품명으로 찾아서 카테고리에서 제거

    /**
     * 상품을 카테고리에서 삭제한다.
     * 상품명으로 검색 후 해당상품을 제거한다.
     */
    public void deleteProduct() {
            System.out.println("삭제할 상품을 입력하세요: ");
            String input = scanner.nextLine();
            Product target = null;
            Category targetCategory = null; //카테고리에 있는 상품도 지워야하기때문

            for (Category category : categories){
                for (Product product : category.getProducts()){
                    if (product.getName().equals(input)){
                        target = product;
                        targetCategory = category; //상품에 속한 카테고리도 저장
                    }
                }
            }
            if (target == null){
                System.out.println("존재하지 않은 상품입니다. ");
                return;
            }
            targetCategory.getProducts().remove(target); // 카테고리에 상품 제거
                System.out.println(target.getName() + "상품이 삭제되었습니다.");
        }
        // 모든 카테고리의 모든 상품 출력

    /**
     * 모든 카테고리안에 있는 상품들을 출력한다.
     */
    public void printAllProduct(){
            System.out.println("[ 전체 상품 현황 ]");
            for (Category category: categories){
                System.out.println("[ " + category.getName() + " ]");
                for (Product product : category.getProducts()){
                    System.out.println(product.getName() + " | " + String.format("%,d", product.getPrice()) + "원 | " + product.getDescription() + " | 재고: " + product.getStock() + "개");
                }
            }
        }
    }


