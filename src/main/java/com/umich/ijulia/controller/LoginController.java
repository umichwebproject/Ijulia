package com.umich.ijulia.controller;

import com.umich.ijulia.dataobject.UserDetail;
import com.umich.ijulia.repository.UserRepository;
import com.umich.ijulia.service.LoginTicketService;
import com.umich.ijulia.service.UserDetailService;
import com.umich.ijulia.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class LoginController {
    @Autowired
    private UserDetailService userDetailService;
    private UserRepository userRepository;
    private LoginTicketService loginTicketService;
    //登陆界面
    @GetMapping("/home")
    public ModelAndView  home(Map<String,Object> map){
        return new ModelAndView("user/userhome",map);
    }

    @GetMapping("/login")
    public ModelAndView loginPage(Map<String,Object> map){
        return new ModelAndView("user/login",map) ;
    }
    @PostMapping("/login")
    public String login(Model model,
                        @RequestParam("email") String email,
                        @RequestParam("password") String password,
                        HttpServletResponse response){
        //TODO 重定向问题，Spring security引入问题(先暂时不引入，用AOP来cutpoint)
        //TODO cookie下发
        String token = userDetailService.login(email,password);
        CookieUtil.set(response,"token",token,3600*24*7);
        return "redirect:/user";
    }
    //登出
    @GetMapping("/logout")
    public void logout(HttpServletRequest request,HttpServletResponse response,
                       Map<String,Object> map){
        Cookie cookie=CookieUtil.get(request,"token");
        if(cookie!=null) {
            loginTicketService.updatestatus(cookie.getValue());
            CookieUtil.set(response, "token", null, 0);
        }
    }

    //注册界面
    @GetMapping("/register")
    public ModelAndView registerPage(Map<String,Object> map){
        return new ModelAndView("user/register",map) ;
    }
    @PostMapping("/register")
    public String register(Model model,String email, String username, String password){
        //TODO 重定向问题，Spring security引入问题(先暂时不引入，用AOP来cutpoint)
        //TODO 验证邮箱是否合法
        try{
        UserDetail result = userDetailService.addUser(email,username,password);
        Map<String,String> map = new HashMap<>();
        map.put("userId",String.valueOf(result.getUserId()));
        return "redirect:/user/login";
        }catch (Exception e){
            log.error(e.getMessage());
            return "redirect:/user/login";
        }
    }


}
