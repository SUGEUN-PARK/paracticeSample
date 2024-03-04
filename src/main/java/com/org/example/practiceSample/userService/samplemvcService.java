package com.org.example.practiceSample.userService;

import com.org.example.practiceSample.userModel.Member;

import javax.servlet.http.HttpServlet;
import java.util.HashMap;
import java.util.List;

public interface samplemvcService  {
    public List<Member> selectUser() throws Exception;
    public void insert(HashMap<String, Object> param) throws Exception;
}
