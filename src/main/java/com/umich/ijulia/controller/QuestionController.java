package com.umich.ijulia.controller;

import com.umich.ijulia.dataobject.LoginTicket;
import com.umich.ijulia.dataobject.QuestionDetail;
import com.umich.ijulia.dataobject.UserDetail;
import com.umich.ijulia.enums.UserResultEnum;
import com.umich.ijulia.exception.USERException;
import com.umich.ijulia.repository.LoginTicketRepository;
import com.umich.ijulia.repository.UserRepository;
import com.umich.ijulia.service.QuestionDetailService;
import com.umich.ijulia.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping("/question")
@Slf4j
public class QuestionController {
    @Autowired
    private QuestionDetailService questionDetailService;
    @Autowired
    private LoginTicketRepository loginTicketRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/addquestion")
    public ModelAndView addquestionPage(Map<String,Object> map){
        return new ModelAndView("question/addquestion",map);
    }
    @PostMapping("/addquestion")
    public String addquestion(Model model,
                        @RequestParam("title") String title,
                        @RequestParam("content") String content,
                        HttpServletResponse response){
        //TODO 重定向问题，Spring security引入问题(先暂时不引入，用AOP来cutpoint)
        //TODO cookie下发
        ServletRequestAttributes attributes =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Cookie cookie = CookieUtil.get(request,"token");
        if(cookie==null){
            throw new USERException(UserResultEnum.USER_NOT_LOGIN);
        }
        String token = cookie.getValue();
        LoginTicket ticket = loginTicketRepository.findByTicket(token);
        UserDetail userDetail = userRepository.findByUserId(ticket.getUserId());
        QuestionDetail questionDetail = new QuestionDetail();
        questionDetail.setUserId(userDetail.getUserId());
        questionDetail.setTitle(title);
        questionDetail.setContent(content);
        questionDetailService.addQuestion(questionDetail);
        return "redirect:/question/home";
    }
    @GetMapping("/home")
    public ModelAndView home(Map<String,Object> map){
        return new ModelAndView("user/userhome",map);
    }

}
