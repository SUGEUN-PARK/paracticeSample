package com.org.example.practiceSample.userService;

import com.org.example.practiceSample.userDao.samplemvcDao;
import com.org.example.practiceSample.userDao.samplemvcDaoImpl;
import com.org.example.practiceSample.userModel.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class samplemvcServiceImpl implements samplemvcService{

    @Autowired
    private samplemvcDao dao;

    @Override
    public List<Member> selectUser() throws Exception {
        return dao.selectUser();
    }

    @Override
    public void insert(HashMap<String, Object> param) throws Exception{
        dao.insert(param);
    }

    @Override
    public List<HashMap<String, Object>> loginUser(HashMap<String, Object> param) throws Exception {
        return dao.loginUser(param);
    }

    @Override
    public String loginCheck(Member memberDTO, HttpSession session) {
        String name = dao.loginCheck(memberDTO);
        if(name != null){
            session.setAttribute("id", memberDTO.getId());
            session.setAttribute("name", memberDTO.getName());

        }

        return name;
    }

    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }

    ;
}
