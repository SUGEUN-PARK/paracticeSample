package com.org.example.practiceSample.userController;

import com.org.example.practiceSample.userModel.Member;
import com.org.example.practiceSample.userModel.MemberRepository;
import com.org.example.practiceSample.userService.samplemvcService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SamplemvcController {

    @Autowired
    samplemvcService service;
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
    @RequestMapping(value = "/memberList2.do")
    public String memberList2(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Member> list = service.selectUser();
        model.addAttribute("list",list);
        return "memberList2";
    }
    @ResponseBody
    @RequestMapping(value = "dbInsert.do", method = {RequestMethod.GET})
    public  String dbInsert(HttpServletRequest request,@RequestParam(value="username", required = false) String username, @RequestParam(value="age", required = false) String age) throws Exception {

        //@RequestParam Map<String,Object> map
//        String username = (String) map.get("username");
//        String age = (String) map.get("age");

//        JSONParser parser = new JSONParser();
//        Object obj1 = parser.parse(username);
//        Object obj2 = parser.parse(age);
//        JSONObject jsonObj1 = (JSONObject) obj1;
//        JSONObject jsonObj2 = (JSONObject) obj2;


        String requestUsername = request.getParameter("username");
        System.out.println("dbInsert 진입");
        System.out.println("username :" + username +", age :" + age);
        System.out.println("requestUsername :" + requestUsername );

        /*Map<String,Object> sendParam = new HashMap<String, Object>();
        sendParam.put("age",age);
        sendParam.put("username",username);*/

        HashMap<String, Object> param = new HashMap<String, Object>();

        param.put("name",username);
        param.put("age",age);
        service.insert(param);

        String message = "db insert success(" +username+","+age+")";
        return message;
    }

    @RequestMapping(value = "/loginPage.do")
    public String loginPage(HttpSession session) {
        Object check_id = session.getAttribute("id");
        String id = (String)check_id;
        if(id == null || id.isEmpty()){
            return "loginPage";
        } else {
            return "sampleMain";
        }

    }
   /* @ResponseBody
    @RequestMapping(value = "/login.do")
    public String login(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception {

        String id = request.getParameter("id");
        String password = request.getParameter("password");
        HashMap<String,Object> param = new HashMap<String, Object>();
        param.put("id", id);
        param.put("password", password);

        List<HashMap<String,Object>> loginUser = service.loginUser(param);

        model.addAttribute("loginUser", loginUser);
        return "login-result";

        *//*String viewPath="/WEB-INF/views/jsp/login-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);*//*
    }*/
    @RequestMapping("/login_check.do")
    public ModelAndView login_check(@ModelAttribute Member memberDTO, HttpSession session){
        String name = service.loginCheck(memberDTO, session);
        ModelAndView mav = new ModelAndView();

        if(name != null){
            mav.setViewName("sampleMain");
        } else {
            mav.setViewName("loginPage");
            mav.addObject("message", "error");
        }
        return mav;
    }
    @RequestMapping("logout.do")
    public ModelAndView logout(HttpSession session, ModelAndView mav) {
        service.logout(session);
        mav.setViewName("loginPage");
        mav.addObject("message", "logout");
        return mav;
    }

}
