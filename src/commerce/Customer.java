package commerce;

/**
 * 고객 정보를 나타내는 클래스
 * 고객명, 이메일, 등급을 관리한다
 */
public class Customer {
    private String name;
    private String email;
    private String grade;

    /**
     * 고객 정보를 받아 고객 객체를 생성한다
     * @param name 고객명
     * @param email 고객이메일
     * @param grade 고객등급
     */
    public Customer(String name, String email, String grade){
        this.name = name;
        this.email = email;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getGrade() {
        return grade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
