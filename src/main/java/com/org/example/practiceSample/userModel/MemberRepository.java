package com.org.example.practiceSample.userModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long,Member> store = new HashMap<Long, Member>();
    private static  long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance(){
        return instance;
    }
    private MemberRepository(){

    }
    public  Member save(Member member){
        member.setNum(++sequence);
        store.put(member.getNum(), member);

        return member;
    }


    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<Member>(store.values());
    }
}
