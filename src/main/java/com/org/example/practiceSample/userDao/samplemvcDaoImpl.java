package com.org.example.practiceSample.userDao;

import com.org.example.practiceSample.userModel.Member;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class samplemvcDaoImpl implements samplemvcDao{
    private static final String namespace= "com.org.example.practiceSample.userMapper";

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<Member> selectUser() throws Exception {

        return sqlSession.selectList(namespace +".selectUser");
    }

    public void insert(HashMap<String, Object> param) {
        String name = param.get("name").toString();
        String age = param.get("age").toString();

        System.out.println("name :" +name+ ",age:"+age);
        sqlSession.insert(namespace +".insertUser",param);
    }

    @Override
    public List<HashMap<String, Object>> loginUser(HashMap<String, Object> param) throws Exception {
        return sqlSession.selectList(namespace+".loginUser",param);

    }

    @Override
    public String loginCheck(Member memberDTO) {
        return sqlSession.selectOne(namespace+".login_check", memberDTO);
    }


}
