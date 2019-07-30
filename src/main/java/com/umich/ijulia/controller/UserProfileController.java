package com.umich.ijulia.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserProfileController {
    @GetMapping("")
    public ModelAndView home(Map<String,Object> map){
        return new ModelAndView("user/userhome",map);
    }
}
