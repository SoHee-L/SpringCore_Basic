package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{
    //구현체 구현체는 위치를 인터페이스와 구현체를 다른 위치에 두는것이 좋지만 예제가 복잡해지니 간단하게 같은페키지에 넣음.
    private static Map<Long,Member> store = new HashMap<>(); // 저장소니까 Map같은게 있어야함.
    //사실 동시성 이슈가 있을 수 있기때문에 ConcurrentHashMap 을 써야함.
    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
        //join에서 save를 호출하면 다형성에 의해서 MemoryMemberRepository();에있는 save(Member member) 여기가 호출이된다.

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //findById하면 store에서 겟해서 넣으면 Id를 찾음.
    }

}
