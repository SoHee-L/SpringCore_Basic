package hello.core.member;

public interface MemberService {
    //두가지 기능이있음 회원가입, 회원조회 (인터페이스먼저만듬. 그다음 구현체(MemberServiceImpl))

    void join(Member member);//회원 가입

    Member findMemeber(Long memberId);//회원 조회
}
