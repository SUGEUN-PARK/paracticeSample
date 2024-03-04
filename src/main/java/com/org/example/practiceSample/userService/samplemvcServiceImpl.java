package com.org.example.practiceSample.userService;

import com.org.example.practiceSample.userDao.samplemvcDao;
import com.org.example.practiceSample.userDao.samplemvcDaoImpl;
import com.org.example.practiceSample.userModel.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

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
    };
}
