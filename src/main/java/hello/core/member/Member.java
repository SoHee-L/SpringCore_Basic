package hello.core.member;

public class Member { //회원은 id, name, grade 세가지 속성만 있음.

    private Long id;
    private String name;
    private Grade grade;

    public Member(Long id, String name, Grade grade) { //생성자 만들어줌.
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public Long getId() { //데이터를 가지고오고 뽑는 게터, 세터 생성 이메서드들을 통해서 private 값을 세팅할 수 있음.
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
