package com.four.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class webJump {
    //控制器作vip页面
    @RequestMapping("vip")
    public String vip(){
        return "vip";
    }
//    @RequestMapping("test")
////    public String Test(){
////        return "Test";
////    }


}
