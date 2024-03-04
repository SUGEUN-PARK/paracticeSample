package com.org.example.practiceSample.userDao;

import com.org.example.practiceSample.userModel.Member;

import java.util.HashMap;
import java.util.List;

public interface samplemvcDao {
    public List<Member> selectUser() throws Exception;

    void insert(HashMap<String, Object> param) throws Exception;
}
