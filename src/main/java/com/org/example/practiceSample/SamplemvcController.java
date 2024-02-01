package com.org.example.practiceSample;

import com.org.example.practiceSample.model.Member;
import com.org.example.practiceSample.model.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SamplemvcController {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping(value = "/sampleMain.do")
    public String SampleMain(){

        return "sampleMain";
    }

    @RequestMapping(value = "/newForm.do")
    public String newForm(){
        return "newForm";
    }

    @RequestMapping(value = "/save.do")
    public void save(Model model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username,age);
        memberRepository.save(member);

        request.setAttribute("member", member);
        //DB 저장을 service로
        //service.save()....

        String viewPath="/WEB-INF/views/jsp/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
    @RequestMapping(value = "/memberList.do")
    public String memberList(Model model, HttpServletRequest request, HttpServletResponse response){
        List<Member> members = memberRepository.findAll();
        request.setAttribute("members", members);
        return "memberList";
    }
}
