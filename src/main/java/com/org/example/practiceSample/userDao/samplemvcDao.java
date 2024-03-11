package com.org.example.practiceSample.userDao;

import com.org.example.practiceSample.userModel.Member;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface samplemvcDao {
    public List<Member> selectUser() throws Exception;
    void insert(HashMap<String, Object> param) throws Exception;
    public List<HashMap<String, Object>> loginUser(HashMap<String, Object> param) throws Exception;

    public String loginCheck(Member memberDTO);
}
