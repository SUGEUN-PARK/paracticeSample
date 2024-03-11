package com.org.example.practiceSample.userService;

import com.org.example.practiceSample.userModel.Member;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface samplemvcService  {
    public List<Member> selectUser() throws Exception;
    public void insert(HashMap<String, Object> param) throws Exception;

    public List<HashMap<String, Object>> loginUser(HashMap<String, Object> param) throws Exception;

    public String loginCheck(Member memberDTO, HttpSession session);
    public void logout(HttpSession session);
}
