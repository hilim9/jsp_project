package models.member;

import org.mindrot.jbcrypt.BCrypt;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

    // DB 연동

    private static Map<String, Member> members = new HashMap<>();

    public void register(Member member) {

        // BCrypt.gensalt(): hash 반복 횟수 설정
        String userPw = BCrypt.hashpw(member.getUserPw(), BCrypt.gensalt(12)); // 12번 반복
        member.setUserPw(userPw);

        members.put(member.getUserId(), member);

    }

    public Member get(String userId) {

        return members.get(userId);

    }

    public boolean exists(String userId) {

        return members.containsKey(userId);

    }

    // 메모리 비우기 (임시 추가)
    public static void clearData() {
        members.clear();
    }

}
